package edu.ea.project.team8.controller;

import edu.ea.project.team8.common.controller.BaseController;
import edu.ea.project.team8.domain.Attendance;
import edu.ea.project.team8.domain.CourseOffering;
import edu.ea.project.team8.domain.Student;
import edu.ea.project.team8.service.AttendanceService;
import edu.ea.project.team8.service.CourseOfferingService;
import edu.ea.project.team8.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/students")
@CrossOrigin(origins = "*")
public class StudentController extends BaseController<Student, Student, Integer> {
	@Autowired
	CourseOfferingService courseOfferingService;
	@Autowired
	AttendanceService attendanceService;

	@RequestMapping(value = "/{id}/offerings", method = RequestMethod.GET)
	public CourseOffering getCourseOfferingsByStudent(@PathVariable("id") Integer sid) {
		return courseOfferingService.findCurrentOfferingsByStudent(sid);
	}

	@RequestMapping(value = "/{id}/offerings/{coid}/attendances/", method = RequestMethod.GET)
	public List<Attendance> getAttendancesOfCourse(@PathVariable("id") Integer sid, @PathVariable("coid") Integer coid) {
		return attendanceService.findOfStudentByCourseOffering(sid, coid);
	}
}
