package edu.ea.project.team8.service;

import java.util.List;

import edu.ea.project.team8.domain.Course;

public interface CourseService {
	public List<Course> findAll();
	public void addCourse(Course course);
}
