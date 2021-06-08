package edu.ea.project.team8.common.service;

import edu.ea.project.team8.common.repository.BaseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Component
@Transactional
public abstract class BaseServiceImpl<T, I> implements  BaseService<T, I>{

    @Autowired
    protected BaseRepository<T, I> baseRepository;

    @Override
    public List<T> findAll() {
        return baseRepository.findAll();
    }

    @Override
    public T findById(I id) {
        return baseRepository.findById(id).orElseThrow();
    }

    @Override
    public T add(T entity) {
        return baseRepository.save(entity);
    }

    @Override
    public T update(T entity) {
        return baseRepository.save(entity);
    }

    @Override
    public void deleteById(I id) {
        baseRepository.deleteById(id);
    }
}
