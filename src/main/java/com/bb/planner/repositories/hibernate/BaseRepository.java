package com.bb.planner.repositories.hibernate;

import com.bb.planner.models.Task;

import java.util.List;

public interface BaseRepository<T, K> {

    List<T> getAll();
    T get(T element);
    T getById(K elementId);
    T add(T element);
    void delete(T element);
}
