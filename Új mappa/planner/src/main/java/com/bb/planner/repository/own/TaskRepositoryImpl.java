package com.bb.planner.repository.own;

import com.bb.planner.models.Task;
import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;

public class TaskRepositoryImpl implements TaskRepository{

    private final EntityManager entityManager;

    public TaskRepositoryImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    public void get(Task element) {
        entityManager.
    }

    @Override
    public void getById(Integer elementId) {

    }

    @Override
    @Transactional
    public void add(Task element) {
        entityManager.persist(element);
    }

    @Override
    public void delete(Task element) {

    }

    @Override
    public void deleteById(Integer elementId) {

    }
}
