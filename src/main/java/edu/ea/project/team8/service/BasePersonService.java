package edu.ea.project.team8.service;

import edu.ea.project.team8.common.service.BaseServiceImpl;
import edu.ea.project.team8.domain.Person;

import java.io.Serializable;

public abstract class BasePersonService<R extends Serializable, T extends Person> extends BaseServiceImpl<R, T, Integer> {
	@Override
	public T update(T entity) {
		Person p = baseRepository.findById(entity.getId()).orElseThrow();
		entity.setPasswordHash(p.getPasswordHash());
		return baseRepository.save(entity);
	}
}
