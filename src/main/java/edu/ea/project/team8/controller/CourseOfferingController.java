package edu.ea.project.team8.controller;

import edu.ea.project.team8.common.controller.BaseController;
import edu.ea.project.team8.domain.Attendance;
import edu.ea.project.team8.domain.CourseOffering;
import edu.ea.project.team8.service.AttendanceService;
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

	@RequestMapping(value = "/{coid}/attendances", method = RequestMethod.GET)
	public List<Attendance> getAttendanceByOffering(@PathVariable("coid") Integer coid) {
		return attendanceService.findByCourseOffering(coid);
	}

	@RequestMapping(value = "/{coid}/attendances/student/{sid}", method = RequestMethod.GET)
	public List<Attendance> getAttendanceByOffering(@PathVariable("sid") Integer sid, @PathVariable("coid") Integer coid) {
		return attendanceService.findOfStudentByCourseOffering(sid, coid);
	}
}
