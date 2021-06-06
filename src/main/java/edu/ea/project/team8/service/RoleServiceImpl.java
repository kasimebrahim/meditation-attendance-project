package edu.ea.project.team8.service;

import edu.ea.project.team8.domain.Role;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service("roleService")
@Transactional(propagation = Propagation.REQUIRED)
public class RoleServiceImpl implements RoleService{
	@Override
	public List<Role> findAll() {
		return null;
	}
}
