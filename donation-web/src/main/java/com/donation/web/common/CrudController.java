package com.donation.web.common;

import java.util.List;

import javax.validation.Valid;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import com.donation.common.CrudService;

public abstract class CrudController<T> {

    public abstract CrudService<T> service();

    @PostMapping
    public T add(@Valid @RequestBody T object) {
        return service().add(object);
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity update(@PathVariable("id") Long id, @Valid @RequestBody T newObjectData) {
        T objectToUpdate = service().getById(id);
        if (objectToUpdate == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(service().update(objectToUpdate, newObjectData), HttpStatus.OK);
    }

    @GetMapping
    @ResponseBody
    public List<T> list() {
        return service().getAll();
    }

    @DeleteMapping(value = "/{id}")
    public void delete(@PathVariable("id") Long id) {
        service().delete(id);
    }

    @GetMapping("/{id}")
    public T getById(@PathVariable Long id) {
        return service().getById(id);
    }
}
