package edu.ea.project.team8.repository;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Repository("courseRepository")
@Transactional(propagation=Propagation.MANDATORY)
public interface CourseRepository {

}
