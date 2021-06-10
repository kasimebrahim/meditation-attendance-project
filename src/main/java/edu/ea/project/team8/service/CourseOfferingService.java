package edu.ea.project.team8.service;

import java.time.LocalDate;
import java.util.List;

import edu.ea.project.team8.common.service.BaseService;
import edu.ea.project.team8.domain.CourseOffering;
import edu.ea.project.team8.domain.Student;

public interface CourseOfferingService extends BaseService<CourseOffering, CourseOffering, Integer> {
	List<CourseOffering> findByCourse(Integer cid);
	List<CourseOffering> findCurrentOfferingsByFaculty(Integer fid);
	List<CourseOffering> findAllOfferingsByFacultyAfter(Integer fid, LocalDate date);
	List<CourseOffering> findAllByFaculty(Integer fid);
	List<CourseOffering> findCurrentOfferingsByStudent(Integer sid);
	List<Student> getStudents(Integer coid);
	List<CourseOffering> find6MOfferingsByFaculty(Integer fid);
	List<CourseOffering> findRegisteredByStudent(Integer sid);
	List<CourseOffering> findNotRegisteredByStudent(Integer sid);
}
