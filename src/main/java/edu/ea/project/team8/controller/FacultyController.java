package edu.ea.project.team8.controller;

import edu.ea.project.team8.common.controller.BaseController;
import edu.ea.project.team8.config.security.AuthUtil;
import edu.ea.project.team8.config.security.CustomUserDetails;
import edu.ea.project.team8.domain.CourseOffering;
import edu.ea.project.team8.domain.Faculty;
import edu.ea.project.team8.dto.FacultyDTO;
import edu.ea.project.team8.service.CourseOfferingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/faculties")
public class FacultyController extends BaseController<FacultyDTO, Faculty, Integer> {
    @Autowired
    CourseOfferingService courseOfferingService;

    @Autowired
    AuthUtil authUtil;

    @Secured({"ROLE_ADMIN"})
    @RequestMapping(value = "/{id}/offerings", method = RequestMethod.GET)
    public List<CourseOffering> getOfferings(@PathVariable("id") Integer fid) {
        return courseOfferingService.find6MOfferingsByFaculty(fid);
    }

    @Secured({"ROLE_FACULTY"})
    @RequestMapping(value = "/offerings", method = RequestMethod.GET)
    public List<CourseOffering> getAllOfferings() {
        CustomUserDetails user = authUtil.getAuthUser();
        return courseOfferingService.find6MOfferingsByFaculty(user.getId());
    }


}
