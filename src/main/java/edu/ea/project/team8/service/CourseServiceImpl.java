package edu.ea.project.team8.service;

import edu.ea.project.team8.common.service.BaseServiceImpl;
import edu.ea.project.team8.domain.Course;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;


@Service("courseService")
@Transactional(propagation = Propagation.REQUIRED)
public class CourseServiceImpl extends BaseServiceImpl<Course, Integer> implements CourseService {

	@Override
	public Course findByCode(String code) {
		return repository.findByCode(code);
	}

}
