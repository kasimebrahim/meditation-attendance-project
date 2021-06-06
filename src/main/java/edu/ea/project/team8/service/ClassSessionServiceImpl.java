package edu.ea.project.team8.service;

import java.util.List;

import edu.ea.project.team8.repository.ClassSessionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import edu.ea.project.team8.domain.ClassSession;


@Service("classSessionService")
@Transactional(propagation=Propagation.REQUIRED)
public class ClassSessionServiceImpl implements ClassSessionService {
	private ClassSessionRepository repository;

	@Autowired
	public ClassSessionServiceImpl(ClassSessionRepository repository) {
		this.repository = repository;
	}

	@Override
	public List<ClassSession> findAll() {
		return repository.findAll();
	}

	@Override
	public void addSession(ClassSession session) {
		repository.save(session);
	}

}
