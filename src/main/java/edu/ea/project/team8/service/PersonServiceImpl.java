package edu.ea.project.team8.service;

import java.util.List;
import java.util.Optional;

import edu.ea.project.team8.config.security.CustomUserDetails;
import edu.ea.project.team8.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import edu.ea.project.team8.domain.Person;


@Service("personService")
@Transactional(propagation=Propagation.REQUIRED)
public class PersonServiceImpl implements PersonService {

	@Qualifier("personRepository")
	@Autowired
	PersonRepository repository;

	@Override
	public List<Person> findAll() {
		return null;
	}

	@Override
	public void addPerson(Person person) {
		person.setPasswordHash(new BCryptPasswordEncoder().encode(person.getPasswordHash()));
		repository.save(person);
	}

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		Optional<Person> person = repository.findByUsername(username);
		return new CustomUserDetails(person.orElseThrow(() -> new UsernameNotFoundException("User not found with username: " + username)));
	}
}
