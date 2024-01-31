package com.bb.planner.repository.own;

import com.bb.planner.models.Task;

import java.util.List;

public interface BaseRepository<T, K> {

    List<T> getAll(T element);
    Task get(T element);
    Task getById(K elementId);
    void add(T element);
    void delete(T element);
}