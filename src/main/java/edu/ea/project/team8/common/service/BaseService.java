package edu.ea.project.team8.common.service;

import java.util.List;

public interface BaseService<R, T, I> {
    public List<R> findAll();
    public R findById(I id);
    public T add(T entity);
    public T update(T entity);
    public void deleteById(I id);
}
