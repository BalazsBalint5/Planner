package com.bb.planner.repositories.hibernate;

import com.bb.planner.models.Task;
import com.bb.planner.models.Topic;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class TopicRepositoryImpl implements TopicRepository {

    private final EntityManager entityManager;
    private final TaskRepository taskRepository;

    public TopicRepositoryImpl(EntityManager entityManager, TaskRepository taskRepository) {
        this.entityManager = entityManager;
        this.taskRepository = taskRepository;
    }

    @Override
    public List<Topic> getAll() {
        TypedQuery<Topic> getAllTopicQuery = entityManager.createQuery("FROM Topic", Topic.class);
        return getAllTopicQuery.getResultList();
    }

    @Override
    public Topic get(Topic element) {
        return entityManager.find(Topic.class, element);
    }

    @Override
    public Topic getById(Integer elementId) {
        return entityManager.find(Topic.class, elementId);
    }

    @Override
    @Transactional
    public Topic add(Topic element) {

        if(element != null){
            entityManager.persist(element);
        }
        return null;
    }

    @Override
    @Transactional
    public void delete(Topic element) {
        entityManager.remove(element);
    }

    @Override
    public List<Task> getTopicTasks(Topic topic) {
        return topic.getTasks();
    }

    @Override
    public Task getTopicTask(Topic topic, Task task) {

        Optional<Task> searchedTask = topic.getTasks().stream().filter(actualTask -> actualTask.equals(task)).findFirst();
        return searchedTask.orElseThrow();
    }

    @Override
    public Task getTopicTaskByName(Topic topic, String taskLabel) {
        return null;
    }
}
