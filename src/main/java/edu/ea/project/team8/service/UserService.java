package edu.ea.project.team8.service;

import edu.ea.project.team8.domain.User;

import java.util.List;

public interface UserService {
	public List<User> findAll();
	public void addUser(User user);
}
