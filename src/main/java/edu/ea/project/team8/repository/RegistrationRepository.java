package edu.ea.project.team8.repository;

import edu.ea.project.team8.domain.Attendance;
import edu.ea.project.team8.domain.Registration;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository("registrationRepository")
@Transactional(propagation = Propagation.MANDATORY)
public interface RegistrationRepository extends JpaRepository<Registration, Integer> {

	@Query("SELECT new edu.ea.project.team8.domain.Attendance(rg.student, sc, at.present, at.id) " +
			"FROM Registration rg left join rg.offering.sessions sc left join Attendance at" +
			" on at.classSession.id = sc.id and at.student.id = rg.student.id" +
			" WHERE sc.id = :sid order by rg.student.lastName")
	List<Attendance> getAttendances(@Param("sid") Integer sid);
}
