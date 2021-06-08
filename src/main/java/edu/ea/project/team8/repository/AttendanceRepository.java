package edu.ea.project.team8.repository;

import edu.ea.project.team8.domain.Attendance;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
@Transactional(propagation = Propagation.MANDATORY)
public interface AttendanceRepository extends JpaRepository<Attendance, Integer> {

	List<Attendance> findByStudentId(Integer personId);

	List<Attendance> findByCourse(Integer courseId);

	List<Attendance> findOfByCourse(Integer personId, Integer courseId);
}
