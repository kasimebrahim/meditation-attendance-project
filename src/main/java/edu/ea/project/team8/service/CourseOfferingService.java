package edu.ea.project.team8.service;

import java.util.List;

import edu.ea.project.team8.domain.CourseOffering;

public interface CourseOfferingService {
	List<CourseOffering> findAll();
	void addCourseOffering(CourseOffering offering);
	List<CourseOffering> findByCourse(Integer cid);
}
