package edu.ea.project.team8.service;

import edu.ea.project.team8.domain.ClassSession;
import edu.ea.project.team8.domain.Course;
import edu.ea.project.team8.domain.CourseOffering;
import edu.ea.project.team8.repository.ClassSessionRepository;
import edu.ea.project.team8.repository.CourseOfferingRepository;
import edu.ea.project.team8.repository.CourseRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
@Transactional(propagation = Propagation.REQUIRED)
public class ClassSessionTest {
	@Autowired
	ClassSessionRepository classSessionRepository;
	@Autowired
	CourseOfferingRepository courseOfferingRepository;
	@Autowired
	CourseRepository courseRepository;

	@Test
	public void findCourse() {
		Course ea = courseRepository.findByCode("CS544");
		CourseOffering cof = courseOfferingRepository.findByCourse(ea.getId()).get(0);
		ClassSession classSession = classSessionRepository.findByCourseOfferingId(cof.getId()).get(0);
		Course result = classSession.getOffering().getCourse();
		System.out.println("Course :\n " + result);
		assertThat(ea).isEqualTo(result);
	}
}
