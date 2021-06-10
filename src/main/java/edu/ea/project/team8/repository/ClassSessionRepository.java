package edu.ea.project.team8.repository;

import edu.ea.project.team8.domain.ClassSession;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

@Repository("classSessionRepository")
@Transactional(propagation = Propagation.MANDATORY)
public interface ClassSessionRepository extends JpaRepository<ClassSession, Integer> {

    @Query("SELECT distinct cs FROM ClassSession cs WHERE cs.offering.id =:cof")
    List<ClassSession> findByCourseOfferingId(@Param("cof") Integer cof);

    @Query("SELECT distinct cs FROM ClassSession cs " +
            "join cs.offering.registrations rg " +
            "WHERE cs.date = :date AND cs.timeslot.endTime > :time AND cs.timeslot.startTime < :time " +
            "AND cs.location.id = :lid " +
            "AND rg.student.id = :sid")
    ClassSession findClassSessionByTime(@Param("date") LocalDate localDate, @Param("time") LocalTime localTime, @Param("lid") Integer locationId, @Param("sid") Integer studentId);
}
