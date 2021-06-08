package edu.ea.project.team8.service;

import edu.ea.project.team8.service.dto.Attendance;

import java.util.List;

public interface AttendanceService {
	public List<Attendance> findAttendancesOf(Integer personiId);
	public List<Attendance> findAttendancesByCourse(Integer courseId);
	public List<Attendance> findAttendancesOfByCourse(Integer personId, Integer courseId);

	List<Attendance> findAttendancesByCourseOffering(Integer offeringId);

	List<Attendance> findAttendancesOfByCourseOffering(Integer studentId, Integer courseOfferingId);
}
