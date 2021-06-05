package edu.ea.project.team8.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import edu.ea.project.team8.domain.Location;


@Service("locationService")
@Transactional(propagation=Propagation.REQUIRED)
public class LocationServiceImpl implements LocationService {

	@Override
	public List<Location> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

}
