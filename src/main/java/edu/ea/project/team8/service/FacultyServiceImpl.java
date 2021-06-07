package edu.ea.project.team8.service;

import edu.ea.project.team8.domain.Faculty;
import edu.ea.project.team8.repository.FacultyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service("facultyService")
@Transactional(propagation = Propagation.REQUIRED)
public class FacultyServiceImpl implements FacultyService{
	private FacultyRepository repository;

	@Autowired
	public FacultyServiceImpl(FacultyRepository facultyRepository) {
		this.repository = facultyRepository;
	}

	@Override
	public List<Faculty> findAll() {
		return repository.findAll();
	}

	@Override
	public Faculty addFaculty(Faculty faculty) {
		return repository.save(faculty);
	}
}
