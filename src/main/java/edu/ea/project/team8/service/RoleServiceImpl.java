package edu.ea.project.team8.service;

import edu.ea.project.team8.domain.Role;
import edu.ea.project.team8.repository.RoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service("roleService")
@Transactional(propagation = Propagation.REQUIRED)
public class RoleServiceImpl implements RoleService{
	private RoleRepository repository;

	@Autowired
	public RoleServiceImpl(RoleRepository repository) {
		this.repository = repository;
	}

	@Override
	public List<Role> findAll() {
		return repository.findAll();
	}

	@Override
	public void addRole(Role role) {
		repository.save(role);
	}
}
