package edu.ea.project.team8.service;

import edu.ea.project.team8.common.service.BaseService;
import edu.ea.project.team8.common.service.BaseServiceImpl;
import edu.ea.project.team8.domain.Attendance;
import edu.ea.project.team8.domain.ClassSession;
import edu.ea.project.team8.domain.Student;
import edu.ea.project.team8.repository.AttendanceRepository;
import edu.ea.project.team8.repository.ClassSessionRepository;
import edu.ea.project.team8.repository.CourseOfferingRepository;
import edu.ea.project.team8.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

@Service("attendanceService")
@Transactional(propagation = Propagation.REQUIRED)
public class AttendanceServiceImpl implements AttendanceService{
	private AttendanceRepository attendanceRepository;
	private StudentRepository studentRepository;
	private ClassSessionRepository classSessionRepository;
	private CourseOfferingRepository courseOfferingRepository;

	@Autowired
	public AttendanceServiceImpl(AttendanceRepository attendanceRepository,
	                             StudentRepository studentRepository,
	                             ClassSessionRepository classSessionRepository,
	                             CourseOfferingRepository courseOfferingRepository) {
		this.attendanceRepository = attendanceRepository;
		this.studentRepository = studentRepository;
		this.classSessionRepository = classSessionRepository;
		this.courseOfferingRepository = courseOfferingRepository;
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
		List<Attendance> attendances = attendanceRepository.findByCourseOffering(coid);
		List<ClassSession> classSessions = classSessionRepository.findByCourseOfferingId(coid);
		List<Student> students = courseOfferingRepository.getStudents(coid);
		return getAllCompleteAttendance(attendances, classSessions, students);
	}

	@Override
	public List<Attendance> findByCourseOfferingAndSession(Integer coid, Integer csid) {
		List<Attendance> attendances = attendanceRepository.findByCourseOfferingAndSession(coid, csid);
		List<Student> students = courseOfferingRepository.getStudents(coid);
		ClassSession classSession = classSessionRepository.getById(csid);
		return getCompleteStudentAttendances(attendances, classSession, students);
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

	@Override
	public Attendance updateAttendance(Attendance attendance) {
		/*
		* Only present attendances are stored. So updating to absent is equal to deleting.
		* */
		if (attendance.isPresent()) {
			return attendanceRepository.save(attendance);
		}
		else {
			attendanceRepository.delete(attendance);
			return null;
		 }
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
		allAttendances.sort(Comparator.comparing(Attendance::getClassSession));
		return allAttendances;
	}

	private List<Attendance> getCompleteStudentAttendances(List<Attendance> attendances,
	                                                       ClassSession classSession, List<Student> students) {
		List<Attendance> allAttendances = new ArrayList<>();
		students.forEach(stu -> {
			for (Attendance att : attendances) {
				if (att.getStudent().equals(stu)) {
					allAttendances.add(att);
					return;
				}
			}
			allAttendances.add(new Attendance(stu, classSession, false));
		});
		allAttendances.sort(Comparator.comparing(Attendance::getStudent));
		return allAttendances;
	}

	private List<Attendance> getAllCompleteAttendance(List<Attendance> attendances,
	                                                  List<ClassSession> classSessions, List<Student> students) {
		List<Attendance> allAttendances = new ArrayList<>();
		classSessions.forEach(cs -> {
			for (Student stu : students) {
				for (Attendance att : attendances) {
					if(att.getClassSession().equals(cs) && att.getStudent().equals(stu)) {
						allAttendances.add(att);
						return;
					}
				}
				allAttendances.add(new Attendance(stu, cs, false));
			}
		});
		allAttendances.sort(Comparator.comparing(Attendance::getClassSession));
		return allAttendances;
	}
}
