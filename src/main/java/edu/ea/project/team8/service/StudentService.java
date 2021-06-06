package edu.ea.project.team8.service;

import java.util.List;

import edu.ea.project.team8.domain.Course;
import edu.ea.project.team8.domain.Student;

public interface StudentService {
	public List<Student> findAll();
	public List<Course> findAllCoursesTaking(Integer id);
	public List<Course> findAllCoursesTaken(Integer id);
	public Student addStudent(Student student);
}
