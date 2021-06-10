package edu.ea.project.team8.service;

import edu.ea.project.team8.common.service.BaseServiceImpl;
import edu.ea.project.team8.domain.Location;
import edu.ea.project.team8.repository.LocationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


@Service("locationService")
@Transactional(propagation = Propagation.REQUIRED)
public class LocationServiceImpl extends BaseServiceImpl<Location, Location, Integer> implements LocationService {

    private final LocationRepository locationRepository;

    @Autowired
    public LocationServiceImpl(LocationRepository locationRepository) {
        this.locationRepository = locationRepository;
    }

    @Override
    protected List<Location> convertToResponseList(List<Location> list) {
        return list;
    }

    @Override
    public Location findByName(String name) {
        return locationRepository.findByName(name);
    }
}
