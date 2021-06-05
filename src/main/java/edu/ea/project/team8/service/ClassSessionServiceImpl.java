package edu.ea.project.team8.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import edu.ea.project.team8.domain.ClassSession;


@Service("classSessionService")
@Transactional(propagation=Propagation.REQUIRED)
public class ClassSessionServiceImpl implements ClassSessionService {

	@Override
	public List<ClassSession> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

}
