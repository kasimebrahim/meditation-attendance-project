package edu.ea.project.team8.controller;

import edu.ea.project.team8.common.controller.BaseController;
import edu.ea.project.team8.domain.Faculty;
import edu.ea.project.team8.dto.FacultyDTO;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/faculties")
@CrossOrigin
public class FacultyController extends BaseController<FacultyDTO, Faculty, Integer> {


}
