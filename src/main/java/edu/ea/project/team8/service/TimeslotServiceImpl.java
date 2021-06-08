package edu.ea.project.team8.service;

import java.util.List;

import edu.ea.project.team8.repository.TimeslotRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import edu.ea.project.team8.domain.Timeslot;


@Service("timeslotService")
@Transactional(propagation=Propagation.REQUIRED)
public class TimeslotServiceImpl implements TimeslotService {

	private TimeslotRepository repository;

	@Autowired
	public TimeslotServiceImpl(@Qualifier("timeslotRepository") TimeslotRepository repository) {
		this.repository = repository;
	}

	@Override
	public List<Timeslot> findAll() {
		return repository.findAll();
	}

	@Override
	public Timeslot findById(Integer id) { return repository.findById(id).orElseThrow(); }

	@Override
	public Timeslot addTimeSlot(Timeslot timeslot) { return repository.save(timeslot); }

	@Override
	public Timeslot updateTimeslot(Timeslot timeslot) { return repository.save(timeslot); }

	@Override
	public void deleteTimeSlotById(Integer id) { repository.deleteById(id); }

}
