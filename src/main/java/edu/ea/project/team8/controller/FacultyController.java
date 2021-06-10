package edu.ea.project.team8.controller;

import edu.ea.project.team8.common.controller.BaseController;
import edu.ea.project.team8.domain.CourseOffering;
import edu.ea.project.team8.domain.Faculty;
import edu.ea.project.team8.dto.FacultyDTO;
import edu.ea.project.team8.service.CourseOfferingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.context.SecurityContextHolder;
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

    @Secured({"ROLE_FACULTY"})
//    @PreAuthorize("")
    @RequestMapping(value = "/{id}/offerings", method = RequestMethod.GET)
    public List<CourseOffering> getOfferings(@PathVariable("id") Integer fid) {
        return courseOfferingService.find6MOfferingsByFaculty(fid);
    }

}
