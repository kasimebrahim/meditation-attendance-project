package edu.ea.project.team8.service;

import java.util.List;

import edu.ea.project.team8.repository.RegistrationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import edu.ea.project.team8.domain.Registration;


@Service("registrationService")
@Transactional(propagation=Propagation.REQUIRED)
public class RegistrationServiceImpl implements RegistrationService {

	private RegistrationRepository repository;

	@Autowired
	public RegistrationServiceImpl(RegistrationRepository repository) {
		this.repository = repository;
	}

	@Override
	public List<Registration> findAll() {
		return repository.findAll();
	}

	@Override
	public void addRegistration(Registration registration) {
		repository.save(registration);
	}

}
