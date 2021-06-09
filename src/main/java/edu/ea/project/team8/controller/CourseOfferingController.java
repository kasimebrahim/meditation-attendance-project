package edu.ea.project.team8.controller;

import edu.ea.project.team8.common.controller.BaseController;
import edu.ea.project.team8.domain.CourseOffering;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/courseofferings")
public class CourseOfferingController extends BaseController<CourseOffering, CourseOffering, Integer> {
}
