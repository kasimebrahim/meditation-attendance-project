package edu.ea.project.team8.service;

import edu.ea.project.team8.domain.Attendance;

import java.util.List;

public interface AttendanceService {
	public List<Attendance> findOf(Integer personiId);
	public List<Attendance> findByCourse(Integer courseId);
	public List<Attendance> findOfByCourse(Integer personId, Integer courseId);
}
