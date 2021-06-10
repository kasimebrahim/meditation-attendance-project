package edu.ea.project.team8.service;

import edu.ea.project.team8.common.service.BaseService;
import edu.ea.project.team8.domain.Location;

public interface LocationService extends BaseService<Location, Location, Integer> {
    Location findByName(String name);
}
