package edu.ea.project.team8.service;

import java.util.List;

import edu.ea.project.team8.domain.Person;
import org.springframework.security.core.userdetails.UserDetailsService;

public interface PersonService extends UserDetailsService {
	public List<Person> findAll();
	public void addPerson(Person person);
}
