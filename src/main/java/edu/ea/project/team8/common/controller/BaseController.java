package edu.ea.project.team8.common.controller;

import edu.ea.project.team8.common.service.BaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Component
@CrossOrigin(methods = {RequestMethod.OPTIONS, RequestMethod.GET, RequestMethod.POST, RequestMethod.PUT, RequestMethod.DELETE, RequestMethod.HEAD})
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
    public ResponseEntity<?> deleteById(@PathVariable("id") I id)  {

        try {
            baseService.deleteById(id);
        }
        catch (org.springframework.dao.DataIntegrityViolationException e){
            return ResponseEntity.badRequest().body("you cannot delete this entity beacuase it has a foreign key relation");
        }
        return  ResponseEntity.ok().body("");
    }
}
