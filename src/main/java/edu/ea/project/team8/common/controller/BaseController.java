package edu.ea.project.team8.common.controller;

import edu.ea.project.team8.common.service.BaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Component
@CrossOrigin(origins = "*")
public abstract class BaseController<R, T,I> {

    @Autowired
    private BaseService<R, T, I> baseService;

    @GetMapping
    public List<R> getAll(){
        return baseService.findAll();
    }

    @GetMapping("/{id}")
    public R getById(@PathVariable("id") I id){
        return baseService.findById(id);
    }

    @PostMapping
    public T add(@RequestBody T entity){
        return baseService.add(entity);
    }

    @PutMapping
    public T update(@RequestBody T entity){
        return baseService.update(entity);
    }

    @DeleteMapping("{id}")
    public void deleteById(@PathVariable("id") I id){
        baseService.deleteById(id);
    }
}
