package edu.ea.project.team8.service;

import java.time.LocalDate;
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
	public List<CourseOffering> findAllByCourse(Integer cid) {
		return repository.findAllByCourse(cid);
	}

	@Override
	public List<CourseOffering> findAllByStudent(Integer sid) {
		return repository.findAllByStudent(sid);
	}

	@Override
	public List<CourseOffering> findAllByBeginDate(LocalDate beginDate) {
		return repository.findAllByBeginDate(beginDate);
	}

	@Override
	public CourseOffering findByStuCouDate(Integer sid, Integer cid, LocalDate beginDate) {
		return repository.findByStuCouDate(sid, cid, beginDate);
	}

}
