package edu.ea.project.team8.service;

import edu.ea.project.team8.common.service.BaseServiceImpl;
import edu.ea.project.team8.domain.Faculty;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Service("facultyService")
@Transactional(propagation = Propagation.REQUIRED)
public class FacultyServiceImpl extends BaseServiceImpl<Faculty, Integer> {

}
