package edu.ea.project.team8.service;

import java.util.List;

import edu.ea.project.team8.domain.CourseOffering;

public interface CourseOfferingService {
	public List<CourseOffering> findAll();
	public void addCourseOffering(CourseOffering offering);
}
