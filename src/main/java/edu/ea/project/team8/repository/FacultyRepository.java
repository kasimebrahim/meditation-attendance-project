package edu.ea.project.team8.repository;

import edu.ea.project.team8.common.repository.BaseRepository;
import edu.ea.project.team8.domain.Faculty;
import edu.ea.project.team8.dto.FacultyDTO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository("facultyRepository")
@Transactional(propagation=Propagation.MANDATORY)
public interface FacultyRepository extends BaseRepository<Faculty, Integer> {

}
