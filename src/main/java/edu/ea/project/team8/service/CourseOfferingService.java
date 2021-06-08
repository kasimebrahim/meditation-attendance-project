package edu.ea.project.team8.service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

import edu.ea.project.team8.domain.ClassSession;
import edu.ea.project.team8.domain.CourseOffering;
import org.springframework.data.repository.query.Param;

public interface CourseOfferingService {
	public List<CourseOffering> findAll();
	public void addCourseOffering(CourseOffering offering);
	public List<CourseOffering> findAllByCourse(Integer cid);
	public List<CourseOffering> findAllByStudent(Integer sid);
	public List<CourseOffering> findAllByBeginDate(LocalDate beginDate);
	public CourseOffering findByStuCouDate(Integer sid, Integer cid, LocalDate beginDate) ;
}
