package edu.ea.project.team8.service;

import edu.ea.project.team8.domain.Attendance;
import edu.ea.project.team8.repository.AttendanceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service("attendanceService")
@Transactional(propagation = Propagation.REQUIRED)
public class AttendanceServiceImpl implements AttendanceService{
	private AttendanceRepository attendanceRepository;

	@Autowired
	public AttendanceServiceImpl(AttendanceRepository attendanceRepository) {
		this.attendanceRepository = attendanceRepository;
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
		 * Find All aAttendances of student in a course in all course offerings.
		 * */
		return attendanceRepository.findOfByCourse(personId, courseId);
	}
}
