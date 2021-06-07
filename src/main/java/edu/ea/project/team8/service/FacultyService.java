package edu.ea.project.team8.service;

import edu.ea.project.team8.domain.Faculty;

import java.util.List;

public interface FacultyService {
	public List<Faculty> findAll();
	public Faculty addFaculty(Faculty faculty);
}
