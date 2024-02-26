package com.bb.planner.services;

import com.bb.planner.models.Task;
import com.bb.planner.models.Topic;

import java.util.List;

public interface TopicService {

    Topic getTopic(Topic topic);
    Topic getTopicById(Integer topicId);
    List<Topic> getAllTopic();
    Topic addTopic(Topic topic);
    Topic saveTaskForTopic(Integer topicId, Task task);
    void deleteTopic(Topic topic);
    void deleteTopicById(Integer topicId);
    List<Task> getAllTaskFromTopicById(Integer topicId);
}
