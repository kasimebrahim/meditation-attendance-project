package edu.ea.project.team8.service;

import edu.ea.project.team8.common.service.BaseService;
import edu.ea.project.team8.domain.Attendance;
import edu.ea.project.team8.domain.Registration;

import java.util.List;

public interface RegistrationService extends BaseService<Registration, Registration, Integer> {
	List<Attendance> getAttendances(Integer sid);
}
