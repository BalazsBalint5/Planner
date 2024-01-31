package com.bb.planner.repository.own;

import java.util.List;

public interface BaseRepository<T, K> {

    List<T> getAll(T element);
    void get(T element);
    void getById(K elementId);
    void add(T element);
    void delete(T element);
}
