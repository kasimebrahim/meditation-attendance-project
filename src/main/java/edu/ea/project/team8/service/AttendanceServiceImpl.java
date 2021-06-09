package edu.ea.project.team8.service;

import edu.ea.project.team8.domain.Attendance;
import edu.ea.project.team8.domain.ClassSession;
import edu.ea.project.team8.repository.AttendanceRepository;
import edu.ea.project.team8.repository.ClassSessionRepository;
import edu.ea.project.team8.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service("attendanceService")
@Transactional(propagation = Propagation.REQUIRED)
public class AttendanceServiceImpl implements AttendanceService{
	private AttendanceRepository attendanceRepository;
	private StudentRepository studentRepository;
	private ClassSessionRepository classSessionRepository;

	@Autowired
	public AttendanceServiceImpl(AttendanceRepository attendanceRepository,
	                             StudentRepository studentRepository,
	                             ClassSessionRepository classSessionRepository) {
		this.attendanceRepository = attendanceRepository;
		this.studentRepository = studentRepository;
		this.classSessionRepository = classSessionRepository;
	}

	public Attendance findById(Integer id) {
		return attendanceRepository.findById(id).orElseThrow();
	}

	public List<Attendance> findOf(Integer personId) {
		/*
		 * Find all attendances of a student in all courses and course offerings.
		 * */
		return attendanceRepository.findByStudentId(personId);
	}

	@Override
	public List<Attendance> findByCourse(Integer courseId) {
		/*
		 * Find all attendances of all students in all course offerings of a course.
		 * */
		return attendanceRepository.findByCourse(courseId);
	}

	@Override
	public List<Attendance> findOfByCourse(Integer personId, Integer courseId) {
		/*
		 * Find All aAttendances of a student in a course in all course offerings.
		 * */
		List<Attendance> attendances = attendanceRepository.findOfByCourse(personId, courseId);
		List<ClassSession> classSessions = attendanceRepository.findSessionsByStudentAndCourse(personId, courseId);
		return getCompleteAttendance(personId, attendances, classSessions);
	}

	@Override
	public List<Attendance> findByCourseOffering(Integer coid) {
		return attendanceRepository.findByCourseOffering(coid);
	}

	@Override
	public List<Attendance> findOfStudentByCourseOffering(Integer sid, Integer cofid) {
		/*
		 * Find All aAttendances of a student in a course in all course offerings.
		 * */
		List<Attendance> attendances = attendanceRepository.findOfStudentByCourseOffering(sid, cofid);
		List<ClassSession> classSessions = classSessionRepository.findByCourseOfferingId(cofid);
		return getCompleteAttendance(sid, attendances, classSessions);
	}

	private List<Attendance> getCompleteAttendance(Integer sid, List<Attendance> attendances, List<ClassSession> classSessions) {
		List<Attendance> allAttendances = new ArrayList<>();
		classSessions.forEach(cs -> {
			for (Attendance att : attendances) {
				if(att.getClassSession().equals(cs)) {
					allAttendances.add(att);
					return;
				}
			}
			allAttendances.add(new Attendance(studentRepository.findById(sid).orElseThrow(), cs, false));
		});
		return allAttendances;
	}
}
