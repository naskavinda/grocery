package com.grocery.inventory.service;

import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public abstract class CrudServiceImpl<T, ID> implements CrudService<T, ID> {

    private JpaRepository<T, ID> jpaRepository;

    protected CrudServiceImpl(JpaRepository<T, ID> jpaRepository) {
        this.jpaRepository = jpaRepository;
    }

    @Override
    public List<T> getAll() {
        return jpaRepository.findAll();
    }

    @Override
    public List<T> getAll(Integer page, Integer size) {
        if (page >= 0) {
            return jpaRepository.findAll(PageRequest.of(page, size)).getContent();
        }
        return jpaRepository.findAll();
    }

    @Override
    public T getById(ID id) {
        return jpaRepository.findById(id).orElse(null);
    }

    @Override
    public void save(T object) {
        jpaRepository.save(object);
    }
}
