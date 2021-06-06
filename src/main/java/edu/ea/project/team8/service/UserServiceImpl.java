package edu.ea.project.team8.service;

import edu.ea.project.team8.domain.User;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service("userService")
@Transactional(propagation= Propagation.REQUIRED)
public class UserServiceImpl implements UserService{
	@Override
	public List<User> findAll() {
		return null;
	}
}
