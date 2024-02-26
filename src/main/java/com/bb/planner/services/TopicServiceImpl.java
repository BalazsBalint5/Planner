package com.bb.planner.services;

import com.bb.planner.models.Task;
import com.bb.planner.models.Topic;
import com.bb.planner.repositories.hibernate.TopicRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TopicServiceImpl implements TopicService {

    private final TopicRepository topicRepository;

    public TopicServiceImpl(TopicRepository topicRepository) {
        this.topicRepository = topicRepository;
    }

    @Override
    public Topic getTopic(Topic topic) {
        return topicRepository.get(topic);
    }

    @Override
    public Topic getTopicById(Integer topicId) {
        return topicRepository.getById(topicId);
    }

    @Override
    public List<Topic> getAllTopic() {
        return topicRepository.getAll();
    }

    @Override
    public Topic addTopic(Topic topic) {
        return topicRepository.add(topic);
    }

    @Override
    public Topic saveTaskForTopic(Integer topicId, Task task) {
        Topic tempTopic = topicRepository.getById(topicId);
        tempTopic.addTask(task);

        return topicRepository.addTaskForTopic(tempTopic);
    }

    @Override
    public void deleteTopic(Topic topic) {
        topicRepository.delete(topic);
    }

    @Override
    public void deleteTopicById(Integer topicId) {
        topicRepository.deleteById(topicId);
    }

    @Override
    public List<Task> getAllTaskFromTopicById(Integer topicId) {
        return topicRepository.getTopicTasks(topicId);
    }
}
