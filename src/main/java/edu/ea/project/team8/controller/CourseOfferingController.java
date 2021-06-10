package edu.ea.project.team8.controller;

import edu.ea.project.team8.common.controller.BaseController;
import edu.ea.project.team8.domain.Attendance;
import edu.ea.project.team8.domain.CourseOffering;
import edu.ea.project.team8.domain.Student;
import edu.ea.project.team8.repository.RegistrationRepository;
import edu.ea.project.team8.service.AttendanceService;
import edu.ea.project.team8.service.CourseOfferingService;
import edu.ea.project.team8.service.RegistrationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/courseofferings")
public class CourseOfferingController extends BaseController<CourseOffering, CourseOffering, Integer> {
	@Autowired
	AttendanceService attendanceService;
	@Autowired
	CourseOfferingService courseOfferingService;
	@Autowired
	RegistrationService registrationService;

//	@RequestMapping(value = "/{coid}/classsessions/{csid}/attendances", method = RequestMethod.GET)
//	public List<Attendance> getAttendanceByOfferingAndSession(@PathVariable("coid") Integer coid, @PathVariable("csid") Integer csid) {
//		return attendanceService.findByCourseOfferingAndSession(coid, csid);
//	}

	@RequestMapping(value = "/{coid}/classsessions/{csid}/attendances", method = RequestMethod.GET)
	public List<Attendance> getAttendanceByOfferingAndSession(@PathVariable("csid") Integer csid){
		return registrationService.getAttendances(csid);
	}

	@RequestMapping(value = "/{coid}/attendances", method = RequestMethod.GET)
	public List<Attendance> getAttendanceByOffering(@PathVariable("coid") Integer coid) {
		return attendanceService.findByCourseOffering(coid);
	}

	@RequestMapping(value = "/{coid}/students/{sid}/attendances", method = RequestMethod.GET)
	public List<Attendance> getAttendanceByOffering(@PathVariable("sid") Integer sid, @PathVariable("coid") Integer coid) {
		return attendanceService.findOfStudentByCourseOffering(sid, coid);
	}

	@RequestMapping(value = "/{coid}/students", method = RequestMethod.GET)
	public List<Student> getStudents(@PathVariable("coid") Integer coid) {
		return courseOfferingService.getStudents(coid);
	}
}
