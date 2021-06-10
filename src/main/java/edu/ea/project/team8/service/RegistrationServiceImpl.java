package edu.ea.project.team8.service;

import edu.ea.project.team8.common.service.BaseServiceImpl;
import edu.ea.project.team8.domain.Registration;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


@Service("registrationService")
@Transactional(propagation = Propagation.REQUIRED)
public class RegistrationServiceImpl extends BaseServiceImpl<Registration, Registration, Integer> implements RegistrationService {

    @Override
    protected List<Registration> convertToResponseList(List<Registration> list) {
        return list;
    }

}
