package edu.ea.project.team8.service;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

import edu.ea.project.team8.common.service.BaseServiceImpl;
import edu.ea.project.team8.dto.CourseOfferingDTO;
import edu.ea.project.team8.repository.CourseOfferingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import edu.ea.project.team8.domain.CourseOffering;


@Service("courseOfferingService")
@Transactional(propagation=Propagation.REQUIRED)
public class CourseOfferingServiceImpl extends BaseServiceImpl<CourseOffering, CourseOffering, Integer> implements CourseOfferingService{

	@Override
	protected List<CourseOffering> convertToResponseList(List<CourseOffering> list) {
		return list;
	}

	@Override
	public void addCourseOffering(CourseOffering offering) {
		repository.save(offering);
	}

	@Override
	public List<CourseOffering> findByCourse(Integer cid) {
		return repository.findByCourse(cid);
	}

	@Override
	public List<CourseOffering> findCurrentOfferingsByFaculty(Integer fid) {
		return repository.findAfterByFaculty(fid, LocalDate.now());
	}

	@Override
	public List<CourseOffering> findAllOfferingsByFacultyAfter(Integer fid, LocalDate date) {
		return repository.findAfterByFaculty(fid, date);
	}

	@Override
	public List<CourseOffering> findAllByFaculty(Integer fid) {
		return repository.findAllByFaculty(fid);
	}

	@Override
	public CourseOffering findCurrentOfferingsByStudent(Integer sid) {
		return repository.findAfterByStudent(sid, LocalDate.now());
	}

}
