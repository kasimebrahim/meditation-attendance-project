package edu.ea.project.team8.repository;

import edu.ea.project.team8.domain.CourseOffering;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Repository("courseOfferingRepository")
@Transactional(propagation=Propagation.MANDATORY)
public interface CourseOfferingRepository extends JpaRepository<CourseOffering, Integer> {

}
