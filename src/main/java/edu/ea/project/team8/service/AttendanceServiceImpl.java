package edu.ea.project.team8.service;

import edu.ea.project.team8.domain.BarCodeRecord;
import edu.ea.project.team8.domain.ClassSession;
import edu.ea.project.team8.domain.CourseOffering;
import edu.ea.project.team8.repository.BarCodeRecordRepository;
import edu.ea.project.team8.repository.ClassSessionRepository;
import edu.ea.project.team8.repository.CourseOfferingRepository;
import edu.ea.project.team8.service.dto.Attendance;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service("attendanceService")
@Transactional(propagation = Propagation.REQUIRED)
public class AttendanceServiceImpl implements AttendanceService{
	BarCodeRecordRepository barCodeRecordRepository;
	ClassSessionRepository classSessionRepository;
	CourseOfferingRepository courseOfferingRepository;

	@Autowired
	public AttendanceServiceImpl(BarCodeRecordRepository barCodeRecordRepository,
	                             ClassSessionRepository classSessionRepository,
	                             CourseOfferingRepository courseOfferingRepository) {
		this.courseOfferingRepository = courseOfferingRepository;
	}

	public List<Attendance> findAttendancesOf(Integer personId) {
		/*
		 * This is very very ugly and temporary should use Attendance view.
		 * */
		return courseOfferingRepository.findAttendanceById(personId);
	}

	@Override
	public List<Attendance> findAttendancesByCourse(Integer courseId) {
		/*
		 * This is very very ugly and temporary should use Attendance view.
		 * */
		return courseOfferingRepository.findAttendanceByCourse(courseId);
	}

	@Override
	public List<Attendance> findAttendancesOfByCourse(Integer personId, Integer courseId) {
		/*
		 * This is very very ugly and temporary should use Attendance view.
		 * */
		return courseOfferingRepository.findAttendanceOfByCourse(personId, courseId);
	}

	@Override
	public List<Attendance> findAttendancesByCourseOffering(Integer offeringId) {
		/*
		 * This is very very ugly and temporary should use Attendance view.
		 * */
		return courseOfferingRepository.findAttendancesByCourseOffering(offeringId);
	}

	@Override
	public List<Attendance> findAttendancesOfByCourseOffering(Integer studentId, Integer courseOfferingId) {
		/*
		 * This is very very ugly and temporary should use Attendance view.
		 * */
		return courseOfferingRepository.findAttendancesOfByCourseOffering(studentId, courseOfferingId);
	}
}
