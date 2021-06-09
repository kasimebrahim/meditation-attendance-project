package edu.ea.project.team8.service;

import edu.ea.project.team8.common.service.BaseServiceImpl;
import edu.ea.project.team8.domain.Location;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


@Service("locationService")
@Transactional(propagation = Propagation.REQUIRED)
public class LocationServiceImpl extends BaseServiceImpl<Location, Location, Integer> implements LocationService {

    @Override
    protected List<Location> convertToResponseList(List<Location> list) {
        return list;
    }
}
