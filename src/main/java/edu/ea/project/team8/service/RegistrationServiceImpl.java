package edu.ea.project.team8.service;

import java.util.List;

import edu.ea.project.team8.common.service.BaseServiceImpl;
import edu.ea.project.team8.repository.RegistrationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import edu.ea.project.team8.domain.Registration;


@Service("registrationService")
@Transactional(propagation=Propagation.REQUIRED)
public class RegistrationServiceImpl extends BaseServiceImpl<Registration, Registration, Integer> implements RegistrationService{

	@Override
	protected List<Registration> convertToResponseList(List<Registration> list) {
		return list;
	}

}
