package edu.ea.project.team8.repository;

import edu.ea.project.team8.domain.Attendance;
import edu.ea.project.team8.domain.ClassSession;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.security.core.parameters.P;
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

	@Query("SELECT ac FROM Attendance ac WHERE ac.classSession.offering.id = :coid")
	List<Attendance> findByCourseOffering(@Param("coid") Integer coid);

	@Query("SELECT distinct ac FROM Attendance ac, Registration rg WHERE " +
			"ac.classSession.offering.id = :cofid " +
			"and rg.student.id = :sid " +
			"and rg.offering = :cofid")
	List<Attendance> findOfStudentByCourseOffering(@Param("sid") Integer sid, @Param("cofid") Integer cofid);

	@Query("SELECT cs FROM CourseOffering cof join cof.sessions cs join cof.registrations rg WHERE rg.student.id = :sid and cof.course.id =:cid")
	List<ClassSession> findSessionsByStudentAndCourse(@Param("sid") Integer sid, @Param("cid") Integer cid);

}
