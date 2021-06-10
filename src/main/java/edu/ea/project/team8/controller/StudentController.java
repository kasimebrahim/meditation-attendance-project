package edu.ea.project.team8.controller;

import edu.ea.project.team8.common.controller.BaseController;
import edu.ea.project.team8.domain.Attendance;
import edu.ea.project.team8.domain.Course;
import edu.ea.project.team8.domain.CourseOffering;
import edu.ea.project.team8.domain.Student;
import edu.ea.project.team8.service.AttendanceService;
import edu.ea.project.team8.service.CourseOfferingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/students")
public class StudentController extends BaseController<Student, Student, Integer> {
    @Autowired
    CourseOfferingService courseOfferingService;
    @Autowired
    AttendanceService attendanceService;

    @Secured({"ROLE_ADMIN", "ROLE_PERSONNEL"})
    @RequestMapping(value = "/{id}/offerings", method = RequestMethod.GET)
    public List<CourseOffering> getCurrentCourseOfferingsByStudent(@PathVariable("id") Integer sid) {
        return courseOfferingService.findCurrentOfferingsByStudent(sid);
    }

    @RequestMapping(value = "/{id}/offerings/{coid}/attendances", method = RequestMethod.GET)
    public List<Attendance> getAttendancesOfCourse(@PathVariable("id") Integer sid, @PathVariable("coid") Integer coid) {
        return attendanceService.findOfStudentByCourseOffering(sid, coid);
    }

    @Secured({"ROLE_ADMIN", "ROLE_PERSONNEL","ROLE_STUDENT"})
    @RequestMapping(value = "/{sid}/registered")
    public List<CourseOffering> getRegistedByStudent(@PathVariable("sid") Integer sid) {
        return courseOfferingService.findRegisteredByStudent(sid);
    }

    @Secured({"ROLE_STUDENT"})
    @RequestMapping(value = "/{sid}/unregistered")
    public List<CourseOffering> getNotRegisteredByStudent(@PathVariable("sid") Integer sid) {
        return courseOfferingService.findNotRegisteredByStudent(sid);
    }
}
