package edu.ea.project.team8.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import edu.ea.project.team8.domain.Course;


@Service("courseService")
@Transactional(propagation=Propagation.REQUIRED)
public class CourseServiceImpl implements CourseService {

	@Override
	public List<Course> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

}
