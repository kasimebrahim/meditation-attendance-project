package edu.ea.project.team8.service;

import java.util.List;

import edu.ea.project.team8.common.service.BaseService;
import edu.ea.project.team8.domain.CourseOffering;

public interface CourseOfferingService extends BaseService<CourseOffering, CourseOffering, Integer> {
	List<CourseOffering> findByCourse(Integer cid);
}
