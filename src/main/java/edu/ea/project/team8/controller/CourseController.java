package edu.ea.project.team8.controller;

import edu.ea.project.team8.common.controller.BaseController;
import edu.ea.project.team8.domain.Course;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/courses")
public class CourseController extends BaseController<Course, Course, Integer> {
}
