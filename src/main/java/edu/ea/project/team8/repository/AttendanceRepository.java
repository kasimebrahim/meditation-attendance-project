package edu.ea.project.team8.repository;

import edu.ea.project.team8.domain.Attendance;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
@Transactional(propagation = Propagation.MANDATORY)
public interface AttendanceRepository extends JpaRepository<Attendance, Integer> {

	@Query("FROM Attendance ac WHERE ac.student.id = :sid")
	List<Attendance> findByStudentId(@Param("sid") Integer sid);

	@Query("SELECT ac FROM Attendance ac WHERE ac.classSession.offering.course.id = :cid")
	List<Attendance> findByCourse(@Param("cid") Integer cid);

	@Query("SELECT ac FROM Attendance ac WHERE ac.student.id = :sid and ac.classSession.offering.course.id = :cid")
	List<Attendance> findOfByCourse(@Param("sid") Integer sid, @Param("cid") Integer cid);
}
