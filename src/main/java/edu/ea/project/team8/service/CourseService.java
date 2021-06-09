package edu.ea.project.team8.service;

import java.util.List;

import edu.ea.project.team8.domain.Course;

public interface CourseService {
	List<Course> findAll();
	void addCourse(Course course);
	Course findByCode(String code);
}
