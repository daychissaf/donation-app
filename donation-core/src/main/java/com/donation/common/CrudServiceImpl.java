package com.donation.common;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;

public class CrudServiceImpl<T> implements CrudService<T> {

    @Autowired
    private CrudRepository<T, Long> crudRepository;

    @Autowired
    private ObjectUpdater objectUpdater;

    @Override
    public T add(T object) {
        return crudRepository.save(object);
    }

    @Override
    public T update(T objectToUpdate, T newObjectData) {
        try {
            objectUpdater.update(objectToUpdate, newObjectData);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return crudRepository.save(objectToUpdate);
    }

    @Override
    public void delete(Long id) {
        crudRepository.delete(id);
    }

    @Override
    public List<T> getAll() {
        return (List<T>) crudRepository.findAll();
    }

    @Override
    public T getById(Long id) {
        return crudRepository.findOne(id);
    }
}