package com.grocery.inventory.service;

import java.util.List;

public interface CrudService<T, ID> {

    List<T> getAll();

    List<T> getAll(Integer page, Integer size);

    T getById(ID id);

    void save(T item);
}
