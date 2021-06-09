package edu.ea.project.team8.service;

import java.util.List;
import java.util.stream.Collectors;

import edu.ea.project.team8.common.service.BaseServiceImpl;
import edu.ea.project.team8.dto.CourseOfferingDTO;
import edu.ea.project.team8.repository.CourseOfferingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import edu.ea.project.team8.domain.CourseOffering;


@Service("courseOfferingService")
@Transactional(propagation=Propagation.REQUIRED)
public class CourseOfferingServiceImpl extends BaseServiceImpl<CourseOffering, CourseOffering, Integer> {

	@Override
	protected List<CourseOffering> convertToResponseList(List<CourseOffering> list) {
		return list;
	}
}
