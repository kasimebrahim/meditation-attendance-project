package edu.ea.project.team8.repository;

import edu.ea.project.team8.common.repository.BaseRepository;
import edu.ea.project.team8.domain.Course;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Repository("courseRepository")
@Transactional(propagation=Propagation.MANDATORY)
public interface CourseRepository extends BaseRepository<Course, Integer> {

}
