package edu.ea.project.team8.service;

import java.util.List;

import edu.ea.project.team8.domain.Registration;

public interface RegistrationService {
	public List<Registration> findAll();
	public void addRegistration(Registration registration);
}
