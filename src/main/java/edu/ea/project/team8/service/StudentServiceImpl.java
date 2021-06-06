package edu.ea.project.team8.service;

import java.time.LocalDate;
import java.util.List;

import edu.ea.project.team8.domain.Course;
import edu.ea.project.team8.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import edu.ea.project.team8.domain.Student;


@Service("studentService")
@Transactional(propagation=Propagation.REQUIRED)
public class StudentServiceImpl implements StudentService {
	private StudentRepository repository;

	@Autowired
	public StudentServiceImpl(StudentRepository repository) {
		this.repository = repository;
	}

	@Override
	public List<Student> findAll() {
		return repository.findAll();
	}

	@Override
	public List<Course> findAllCoursesTaking(Integer id) {
		return repository.findAllCoursesTaking(id, LocalDate.now());
	}

	@Override
	public List<Course> findAllCoursesTaken(Integer id) {
		return repository.findAllCoursesTakenBefore(id, LocalDate.now());
	}

	@Override
	public Student addStudent(Student student) {
		return repository.save(student);
	}

}
