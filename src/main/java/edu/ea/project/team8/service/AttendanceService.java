package edu.ea.project.team8.service;

import edu.ea.project.team8.common.service.BaseService;
import edu.ea.project.team8.domain.Attendance;

import java.util.List;

public interface AttendanceService {
	List<Attendance> findOf(Integer personiId);
	List<Attendance> findByCourse(Integer courseId);
	List<Attendance> findOfByCourse(Integer personId, Integer courseId);
	List<Attendance> findByCourseOffering(Integer coid);
	List<Attendance> findOfStudentByCourseOffering(Integer id, Integer id1);

	Attendance updateAttendance(Attendance attendance);

	List<Attendance> findByCourseOfferingAndSession(Integer coid, Integer csid);
}
