package com.grocery.inventory.service;

import java.util.List;

public interface CrudService<T, ID> {

    List<T> getAll();

    T getById(ID id);

    void save(T item);
}
