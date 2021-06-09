package edu.ea.project.team8.service;

import java.util.List;

import edu.ea.project.team8.repository.CourseOfferingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import edu.ea.project.team8.domain.CourseOffering;


@Service("courseOfferingService")
@Transactional(propagation=Propagation.REQUIRED)
public class CourseOfferingServiceImpl implements CourseOfferingService {

	private CourseOfferingRepository repository;

	@Autowired
	public CourseOfferingServiceImpl(CourseOfferingRepository repository) {
		this.repository = repository;
	}

	@Override
	public List<CourseOffering> findAll() {
		return repository.findAll();
	}

	@Override
	public void addCourseOffering(CourseOffering offering) {
		repository.save(offering);
	}

	@Override
	public List<CourseOffering> findByCourse(Integer cid) {
		return repository.findByCourse(cid);
	}

}
