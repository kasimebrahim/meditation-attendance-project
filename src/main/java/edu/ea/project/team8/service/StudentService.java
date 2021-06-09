package edu.ea.project.team8.service;

import java.util.List;

import edu.ea.project.team8.common.service.BaseService;
import edu.ea.project.team8.domain.Course;
import edu.ea.project.team8.domain.Student;

public interface StudentService extends BaseService<Student, Student, Integer> {
	public List<Course> findAllCoursesTaking(Integer id);
	public List<Course> findAllCoursesTaken(Integer id);
	public Student findByUsername(String name);
}
