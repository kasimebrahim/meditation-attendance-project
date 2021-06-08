package edu.ea.project.team8.service;

import edu.ea.project.team8.domain.User;
import org.springframework.security.core.userdetails.UserDetailsService;

import java.util.List;

public interface UserService extends UserDetailsService {
	public List<User> findAll();
	public void addUser(User user);
}
