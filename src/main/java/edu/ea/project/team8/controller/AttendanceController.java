package edu.ea.project.team8.controller;

import edu.ea.project.team8.domain.Attendance;
import edu.ea.project.team8.service.AttendanceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/attendances")
@CrossOrigin
public class AttendanceController {
	@Autowired
	AttendanceService attendanceService;

	@Secured({"ROLE_ADMIN", "ROLE_PERSONNEL"})
	@RequestMapping(value = "/", method = RequestMethod.PUT)
	public Attendance updateAttendance(@RequestBody Attendance attendance) {
		return attendanceService.updateAttendance(new Attendance());
	}
}
