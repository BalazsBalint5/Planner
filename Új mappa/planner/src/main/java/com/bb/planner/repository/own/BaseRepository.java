package com.bb.planner.repository.own;

public interface BaseRepository<T, K> {

    void get(T element);
    void getById(K elementId);
    void add(T element);
    void delete(T element);
    void deleteById(K elementId);
}
