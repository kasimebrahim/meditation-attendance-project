package edu.ea.project.team8.common.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.io.Serializable;
import java.util.Arrays;
import java.util.List;

@Component
@Transactional
public abstract class BaseServiceImpl<R extends Serializable, T, I> implements BaseService<R, T, I> {

    @Autowired
    protected JpaRepository<T, I> baseRepository;

    @Override
    public List<R> findAll() {
        return convertToResponseList(baseRepository.findAll());
    }

    @Override
    public R findById(I id) {
        T entity = baseRepository.findById(id).orElseThrow();
        return convertToResponseList(Arrays.asList(entity)).get(0);
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

    protected abstract List<R> convertToResponseList(List<T> list);

}
