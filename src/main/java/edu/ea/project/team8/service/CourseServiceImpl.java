package edu.ea.project.team8.service;

import java.util.List;

import edu.ea.project.team8.repository.CourseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import edu.ea.project.team8.domain.Course;


@Service("courseService")
@Transactional(propagation=Propagation.REQUIRED)
public class CourseServiceImpl implements CourseService {

	private CourseRepository repository;

	@Autowired
	public CourseServiceImpl(CourseRepository repository) {
		this.repository = repository;
	}

	@Override
	public List<Course> findAll() {
		return repository.findAll();
	}

	@Override
	public void addCourse(Course course) {
		repository.save(course);
	}

	@Override
	public Course findByCode(String code) {
		return repository.findByCode(code);
	}

}
