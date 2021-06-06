package edu.ea.project.team8.service;

import edu.ea.project.team8.domain.User;
import edu.ea.project.team8.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service("userService")
@Transactional(propagation= Propagation.REQUIRED)
public class UserServiceImpl implements UserService{
	private UserRepository repository;

	@Autowired
	public UserServiceImpl(UserRepository repository) {
		this.repository = repository;
	}

	@Override
	public List<User> findAll() {
		return null;
	}

	@Override
	public void addUser(User user) {
		repository.save(user);
	}
}
