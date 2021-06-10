package edu.ea.project.team8.service;

import java.time.LocalDate;
import java.util.List;

import edu.ea.project.team8.common.service.BaseServiceImpl;
import edu.ea.project.team8.domain.Student;
import edu.ea.project.team8.repository.CourseOfferingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import edu.ea.project.team8.domain.CourseOffering;


@Service("courseOfferingService")
@Transactional(propagation=Propagation.REQUIRED)
public class CourseOfferingServiceImpl extends BaseServiceImpl<CourseOffering, CourseOffering, Integer> implements CourseOfferingService{

	private CourseOfferingRepository repository;

	@Autowired
	public CourseOfferingServiceImpl(CourseOfferingRepository courseOfferingRepository) {
		this.repository = courseOfferingRepository;
	}

	@Override
	protected List<CourseOffering> convertToResponseList(List<CourseOffering> list) {
		return list;
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
	public List<CourseOffering> findCurrentOfferingsByStudent(Integer sid) {
		return repository.findAfterByStudent(sid, LocalDate.now());
	}

	@Override
	public List<Student> getStudents(Integer coid) {
		return repository.getStudents(coid);
	}

	@Override
	public List<CourseOffering> find6MOfferingsByFaculty(Integer fid) {
		return repository.findAfterByFaculty(fid, LocalDate.now().minusMonths(6));
	}

	@Override
	public List<CourseOffering> findRegisteredByStudent(Integer sid) {
		return repository.findAfterByStudent(sid, LocalDate.now().minusMonths(6));
	}

	@Override
	public List<CourseOffering> findNotRegisteredByStudent(Integer sid) {
		return repository.findNotRegisteredByStudent(sid, LocalDate.now());
	}
}
