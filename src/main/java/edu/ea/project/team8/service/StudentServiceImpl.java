package edu.ea.project.team8.service;

import edu.ea.project.team8.common.service.BaseServiceImpl;
import edu.ea.project.team8.domain.Course;
import edu.ea.project.team8.domain.Student;
import edu.ea.project.team8.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.List;

@Service("studentService")
@Transactional(propagation = Propagation.REQUIRED)
public class StudentServiceImpl extends BaseServiceImpl<Student, Student, Integer> implements StudentService {
	private final StudentRepository repository;


	@Autowired
	public StudentServiceImpl(@Qualifier("studentRepository") StudentRepository repository) {
		this.repository = repository;
	}


	@Override
	public List<Course> findAllCoursesTaking(Integer id) {
		return ((StudentRepository) baseRepository).findAllCoursesTaking(id, LocalDate.now());
	}

	@Override
	public List<Course> findAllCoursesTaken(Integer id) {
		return ((StudentRepository) baseRepository).findAllCoursesTakenBefore(id, LocalDate.now());
	}

	@Override
	public Student findByUsername(String name) {
		return repository.findByUsername(name);
	}

	@Override
	protected List<Student> convertToResponseList(List<Student> list) {
		return list;
	}
}
