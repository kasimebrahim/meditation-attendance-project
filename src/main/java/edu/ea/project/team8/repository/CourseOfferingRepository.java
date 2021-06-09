package edu.ea.project.team8.repository;

import edu.ea.project.team8.domain.Course;
import edu.ea.project.team8.domain.CourseOffering;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Map;

@Repository("courseOfferingRepository")
@Transactional(propagation=Propagation.MANDATORY)
public interface CourseOfferingRepository extends JpaRepository<CourseOffering, Integer> {

	@Query("SELECT cof from CourseOffering cof WHERE cof.course.id = :cid")
	List<CourseOffering> findByCourse(@Param("cid") Integer cid);
}
