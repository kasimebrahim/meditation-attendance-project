package edu.ea.project.team8.service;

import edu.ea.project.team8.domain.*;
import edu.ea.project.team8.repository.AttendanceRepository;
import edu.ea.project.team8.repository.ClassSessionRepository;
import edu.ea.project.team8.repository.StudentRepository;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.when;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

@SpringBootTest
public class AttendanceTest {
	@Autowired
	CourseService courseService;
	@Autowired
	StudentService studentService;
	@Autowired
	AttendanceService attendanceService;
	@Autowired
	CourseOfferingService courseOfferingService;
	@Mock
	AttendanceRepository attendanceRepository;
	@Mock
	StudentRepository studentRepository;
	@Mock
	ClassSessionRepository classSessionRepository;

	@Test
	public void getStudentAttendancesTest() {
		Student student = studentService.findByUsername("samson");
		List<Attendance> attendances = attendanceService.findOf(student.getId());
		System.out.println("Attendances:\n" + attendances.size());
		assertThat(attendances.size()).isEqualTo(3);
	}

	@Test
	public void getCourseAttendancesTest() {
		Course course = courseService.findByCode("CS544");
		List<Attendance> attendances = attendanceService.findByCourse(course.getId());
		System.out.println("Attendances:\n" + attendances.size());
		assertThat(attendances.size()).isEqualTo(3);
	}

	@Test
	public void getCourseAttendancesOfStudentTest() {
		Course course = courseService.findByCode("CS544");
		Student student = studentService.findByUsername("samson");
		List<Attendance> attendances = attendanceService.findOfByCourse(student.getId(), course.getId());
		System.out.println("Attendances:\n" + attendances);
		assertThat(attendances.size()).isEqualTo(6);
	}

	@Test
	public void getAttendancesByCourseOfferingTest() {
		Course course = courseService.findByCode("CS544");
		CourseOffering courseOffering = courseOfferingService.findByCourse(course.getId()).get(0);
		List<Attendance> attendances = attendanceService.findByCourseOffering(courseOffering.getId());
		System.out.println("Attendances:\n" + attendances);
		assertThat(attendances.size()).isEqualTo(3);
	}

	@Test
	public void getAttendancesOfStudentByCourseOfferingTest() {
		Course course = courseService.findByCode("CS544");
		Student student = studentService.findByUsername("samson");
		CourseOffering courseOffering = courseOfferingService.findByCourse(course.getId()).get(0);
		List<Attendance> attendances = attendanceService.findOfStudentByCourseOffering(student.getId(), courseOffering.getId());
		System.out.println("Attendances:\n" + attendances);
		assertThat(attendances.size()).isEqualTo(6);
	}

	@Test
	public void getCompleteAttendanceTest() {
		AttendanceService service = new AttendanceServiceImpl(attendanceRepository, studentRepository, classSessionRepository);
		Student student = new Student();
		student.setId(1);
		ClassSession cs1 = new ClassSession();
		cs1.setDate(LocalDate.parse("2020-05-05"));
		ClassSession cs2 = new ClassSession();
		cs2.setDate(LocalDate.parse("2020-05-06"));
		ClassSession cs3 = new ClassSession();
		cs3.setDate(LocalDate.parse("2020-05-07"));
		ClassSession cs4 = new ClassSession();
		cs4.setDate(LocalDate.parse("2020-05-08"));
		Attendance a1 = new Attendance(student, cs1);
		Attendance a2 = new Attendance(student, cs3);
		Attendance a3 = new Attendance(student, cs2, false);
		Attendance a4 = new Attendance(student, cs4, false);

		when(attendanceRepository.findOfStudentByCourseOffering(student.getId(), 2))
				.thenReturn(Arrays.asList(a1, a2));
		when(classSessionRepository.findByCourseOfferingId(2))
				.thenReturn(Arrays.asList(cs1, cs2, cs3, cs4));
		when(studentRepository.findById(student.getId()))
				.thenReturn(java.util.Optional.of(student));
		List<Attendance> attendances = service.findOfStudentByCourseOffering(student.getId(), 2);
		assertThat(attendances).isEqualTo(Arrays.asList(a1, a3, a2, a4));
		System.out.println(attendances.size());
	}


}
