package edu.ea.project.team8.service;

import edu.ea.project.team8.common.service.BaseServiceImpl;
import edu.ea.project.team8.domain.Timeslot;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;


@Service("timeslotService")
@Transactional(propagation = Propagation.REQUIRED)
public class TimeslotServiceImpl extends BaseServiceImpl<Timeslot, Integer> {

}
