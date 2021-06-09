package edu.ea.project.team8.service;

import edu.ea.project.team8.common.service.BaseServiceImpl;
import edu.ea.project.team8.domain.Timeslot;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


@Service("timeslotService")
@Transactional(propagation = Propagation.REQUIRED)

public class TimeslotServiceImpl extends BaseServiceImpl<Timeslot, Timeslot, Integer> implements TimeslotService {

    @Override
    protected List<Timeslot> convertToResponseList(List<Timeslot> list) {
        return list;
    }
}
