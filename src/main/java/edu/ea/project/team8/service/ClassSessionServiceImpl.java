package edu.ea.project.team8.service;

import java.util.List;

import edu.ea.project.team8.common.service.BaseServiceImpl;
import edu.ea.project.team8.repository.ClassSessionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import edu.ea.project.team8.domain.ClassSession;


@Service("classSessionService")
@Transactional(propagation=Propagation.REQUIRED)
public class ClassSessionServiceImpl extends BaseServiceImpl<ClassSession, ClassSession, Integer> implements ClassSessionService {
	@Override
	protected List<ClassSession> convertToResponseList(List<ClassSession> list) {
		return list;
	}
}
