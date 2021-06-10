package edu.ea.project.team8.service;

import edu.ea.project.team8.common.service.BaseService;
import edu.ea.project.team8.domain.Course;
import edu.ea.project.team8.domain.Student;

import java.util.List;

public interface StudentService extends BaseService<Student, Student, Integer> {
    List<Course> findAllCoursesTaking(Integer id);

    List<Course> findAllCoursesTaken(Integer id);

    Student findByUsername(String name);
}
