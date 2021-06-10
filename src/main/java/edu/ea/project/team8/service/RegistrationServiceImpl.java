package edu.ea.project.team8.service;

import edu.ea.project.team8.common.service.BaseServiceImpl;
import edu.ea.project.team8.domain.Attendance;
import edu.ea.project.team8.domain.Registration;
import edu.ea.project.team8.repository.RegistrationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


@Service("registrationService")
@Transactional(propagation = Propagation.REQUIRED)
public class RegistrationServiceImpl extends BaseServiceImpl<Registration, Registration, Integer> implements RegistrationService {
    @Autowired
    RegistrationRepository repository;

    @Override
    protected List<Registration> convertToResponseList(List<Registration> list) {
        return list;
    }

    @Override
    public List<Attendance> getAttendances(Integer sid) {
        return repository.getAttendances(sid);
    }
}
