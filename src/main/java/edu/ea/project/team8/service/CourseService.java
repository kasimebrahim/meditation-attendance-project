package edu.ea.project.team8.service;

import edu.ea.project.team8.common.service.BaseService;
import edu.ea.project.team8.domain.Course;

public interface CourseService extends BaseService<Course, Course, Integer> {
    Course findByCode(String code);
}
