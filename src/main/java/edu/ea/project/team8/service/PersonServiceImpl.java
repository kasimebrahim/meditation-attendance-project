package edu.ea.project.team8.service;

import edu.ea.project.team8.common.service.BaseServiceImpl;
import edu.ea.project.team8.config.security.CustomUserDetails;
import edu.ea.project.team8.domain.Person;
import edu.ea.project.team8.repository.PersonRepository;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;


@Service("personService")
@Transactional(propagation = Propagation.REQUIRED)
public class PersonServiceImpl extends BasePersonService<Person, Person> implements PersonService {


    @Override
    protected List<Person> convertToResponseList(List<Person> list) {
        return list;
    }


    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<Person> person = ((PersonRepository) baseRepository).findByUsername(username);
        return new CustomUserDetails(person.orElseThrow(() -> new UsernameNotFoundException("User not found with username: " + username)));
    }
}
