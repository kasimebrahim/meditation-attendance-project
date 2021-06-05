package edu.ea.project.team8.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import edu.ea.project.team8.domain.Timeslot;


@Service("timeslotService")
@Transactional(propagation=Propagation.REQUIRED)
public class TimeslotServiceImpl implements TimeslotService {

	@Override
	public List<Timeslot> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

}
