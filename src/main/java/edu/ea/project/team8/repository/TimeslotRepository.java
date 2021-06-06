package edu.ea.project.team8.repository;

import edu.ea.project.team8.domain.Timeslot;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Repository("timeslotRepository")
@Transactional(propagation=Propagation.MANDATORY)
public interface TimeslotRepository extends JpaRepository<Timeslot, Integer> {

}
