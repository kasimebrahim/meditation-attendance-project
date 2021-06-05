package edu.ea.project.team8.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import edu.ea.project.team8.domain.Registration;


@Service("registrationService")
@Transactional(propagation=Propagation.REQUIRED)
public class RegistrationServiceImpl implements RegistrationService {

	@Override
	public List<Registration> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

}
