package edu.ea.project.team8.service;

import edu.ea.project.team8.domain.Location;

import java.util.List;

public interface LocationService {
	public List<Location> findAll();

	Location findById(Integer id);

	Location findByName(String name);
}
