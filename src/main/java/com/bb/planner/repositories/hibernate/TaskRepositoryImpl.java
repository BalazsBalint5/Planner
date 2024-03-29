package com.bb.planner.repositories.own;

import com.bb.planner.models.Task;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Slf4j
public class TaskRepositoryImpl implements TaskRepository{

    private final EntityManager entityManager;

    public TaskRepositoryImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    public List<Task> getAll() {
        TypedQuery<Task> theQuery = entityManager.createQuery("FROM Task", Task.class);
        return theQuery.getResultList();
    }

    @Override
    public Task get(Task element) {
        return entityManager.find(Task.class, element);
    }

    @Override
    public Task getById(Integer elementId) {
        return entityManager.find(Task.class, elementId);
    }

    @Override
    @Transactional
    public Task add(Task element) {
        entityManager.persist(element);
        return element;
    }

    @Override
    public void delete(Task element) {
        entityManager.remove(element);
    }
}
