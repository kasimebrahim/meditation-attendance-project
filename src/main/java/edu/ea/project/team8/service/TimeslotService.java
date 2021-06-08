package edu.ea.project.team8.service;

import java.util.List;

import edu.ea.project.team8.domain.Timeslot;

public interface TimeslotService {
	public List<Timeslot> findAll();
	public Timeslot findById(Integer id);
	public Timeslot addTimeSlot(Timeslot timeslot);
	public Timeslot updateTimeslot(Timeslot timeslot);
	public void deleteTimeSlotById(Integer id);
}
