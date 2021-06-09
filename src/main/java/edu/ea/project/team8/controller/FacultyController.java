package edu.ea.project.team8.controller;

import edu.ea.project.team8.common.controller.BaseController;
import edu.ea.project.team8.domain.Attendance;
import edu.ea.project.team8.domain.Course;
import edu.ea.project.team8.domain.CourseOffering;
import edu.ea.project.team8.domain.Faculty;
import edu.ea.project.team8.dto.FacultyDTO;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import edu.ea.project.team8.service.AttendanceService;
import edu.ea.project.team8.service.CourseOfferingService;
import edu.ea.project.team8.service.FacultyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/faculties")
@CrossOrigin(origins = "*")
public class FacultyController extends BaseController<FacultyDTO, Faculty, Integer> {
	@Autowired
	CourseOfferingService courseOfferingService;
	@Autowired
	AttendanceService attendanceService;

	@RequestMapping("")
	public List<CourseOffering> getAllOfferingsAfter(@PathVariable("id") Integer fid, LocalDate date) {
		if (date == null)
			return courseOfferingService.findAllByFaculty(fid);
		return courseOfferingService.findAllOfferingsByFacultyAfter(fid, date);
	}

	@RequestMapping(value = "/{id}/offerings", method = RequestMethod.GET)
	public List<CourseOffering> getOfferings(@PathVariable("id") Integer fid) {
		return courseOfferingService.findCurrentOfferingsByFaculty(fid);
	}

	@RequestMapping(value = "/id/offerings/{coid}/attendances", method = RequestMethod.GET)
	public List<Attendance> getAttendanceByOffering(@PathVariable("coid") Integer coid) {
		return attendanceService.findByCourseOffering(coid);
	}

	@RequestMapping(value = "/id/offerings/{coid}/attendances/student/{sid}", method = RequestMethod.GET)
	public List<Attendance> getAttendanceByOffering(@PathVariable("sid") Integer sid, @PathVariable("coid") Integer coid) {
		return attendanceService.findOfStudentByCourseOffering(sid, coid);
	}

	@RequestMapping(value = "/id/offerings/coid/attendances/", method = RequestMethod.PUT)
	public Attendance updateAttendance(@RequestBody Attendance attendance) {
		return attendanceService.updateAttendance(new Attendance());
	}
}
