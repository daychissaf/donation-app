package com.donation.common;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public abstract class CrudServiceImpl<T> implements CrudService<T> {


    @Autowired
    private ObjectUpdater objectUpdater;

    protected abstract CrudRepository<T, Long> repository();

    @Override
    public T add(T object) {
        return repository().save(object);
    }

    @Override
    public T update(T objectToUpdate, T newObjectData) {
        try {
            objectUpdater.update(objectToUpdate, newObjectData);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return repository().save(objectToUpdate);
    }

    @Override
    public void delete(Long id) {
        repository().delete(id);
    }

    @Override
    public List<T> getAll() {
        return (List<T>) repository().findAll();
    }

    @Override
    public T getById(Long id) {
        return repository().findOne(id);
    }
}