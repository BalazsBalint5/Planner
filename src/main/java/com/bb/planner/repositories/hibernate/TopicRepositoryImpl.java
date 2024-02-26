package com.bb.planner.repositories.hibernate;

import com.bb.planner.models.Task;
import com.bb.planner.models.Topic;
import jakarta.persistence.EntityExistsException;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
@Slf4j
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

        if(element == null) {
            log.info("Topic element can't be null");
            return null;
        }

        try{
            log.info("Trying to save topic element: " + element);
            entityManager.persist(element);
        } catch (EntityExistsException e){
            log.info("Couldn't save the topic. It's already exists");
        }

        return element;
    }

    @Override
    @Transactional
    public void delete(Topic element) {
        entityManager.remove(element);
    }

    @Override
    @Transactional
    public void deleteById(Integer elementId) {
        Topic deleteTopic = getById(elementId);
        entityManager.remove(deleteTopic);
    }

    @Override
    public List<Task> getTopicTasks(Topic topic) {
        return topic.getTasks();
    }

    @Override
    public List<Task> getTopicTasks(Integer topicId) {
        return getById(topicId).getTasks();
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

    @Override
    @Transactional
    public Topic addTaskForTopic(Topic topic) {
        entityManager.merge(topic);
        return topic;
    }
}
