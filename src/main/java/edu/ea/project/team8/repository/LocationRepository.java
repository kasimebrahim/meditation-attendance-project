package edu.ea.project.team8.repository;

import edu.ea.project.team8.domain.Location;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Repository("locationRepository")
@Transactional(propagation=Propagation.MANDATORY)
public interface LocationRepository extends JpaRepository<Location, Integer> {
	Location findByName(String name);
}
