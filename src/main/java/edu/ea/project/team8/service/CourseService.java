package edu.ea.project.team8.service;

public interface CourseService {
	List<Course> findAll();
	void addCourse(Course course);
	Course findByCode(String code);
}
