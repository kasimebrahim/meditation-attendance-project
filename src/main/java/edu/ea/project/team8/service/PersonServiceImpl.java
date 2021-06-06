package edu.ea.project.team8.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import edu.ea.project.team8.domain.Person;


@Service("personService")
@Transactional(propagation=Propagation.REQUIRED, readOnly = true)
public class PersonServiceImpl implements PersonService {

	@Override
	public List<Person> findAll() {
		return null;
	}

}
