package edu.ea.project.team8.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import edu.ea.project.team8.domain.Student;


@Service("studentService")
@Transactional(propagation=Propagation.REQUIRED)
public class StudentServiceImpl implements StudentService {

	@Override
	public List<Student> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

}
