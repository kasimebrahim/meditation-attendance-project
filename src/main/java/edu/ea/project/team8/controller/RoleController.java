package edu.ea.project.team8.controller;

import edu.ea.project.team8.common.controller.BaseController;
import edu.ea.project.team8.domain.Role;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/roles")
@CrossOrigin(origins = "*")
public class RoleController extends BaseController<Role, Role, Integer> {
}
