package edu.ea.project.team8.service;

import java.util.List;

import edu.ea.project.team8.repository.LocationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import edu.ea.project.team8.domain.Location;


@Service("locationService")
@Transactional(propagation=Propagation.REQUIRED)
public class LocationServiceImpl implements LocationService {

	private LocationRepository repository;

	@Autowired
	public LocationServiceImpl(LocationRepository repository) {
		this.repository = repository;
	}

	@Override
	public List<Location> findAll() {
		return repository.findAll();
	}

	@Override
	public Location findById(Integer id) {
		return repository.findById(id).orElseThrow();
	}

	@Override
	public Location findByName(String name) {
		return repository.findByName(name);
	}

}
