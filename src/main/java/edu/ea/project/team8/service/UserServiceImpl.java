package edu.ea.project.team8.service;

import edu.ea.project.team8.config.security.CustomUserDetails;
import edu.ea.project.team8.domain.User;
import edu.ea.project.team8.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

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
		user.setPasswordHash(new BCryptPasswordEncoder().encode(user.getPasswordHash()));
		repository.save(user);
	}

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		Optional<User> user = repository.findByUsername(username);
		return new CustomUserDetails(user.orElseThrow(() -> new UsernameNotFoundException("User not found with username: " + username)));
	}
}
