package com.bb.planner.repositories.hibernate;

import com.bb.planner.models.Task;
import com.bb.planner.models.Topic;

import java.util.List;

public interface TopicRepository extends BaseRepository<Topic, Integer>{

    List<Task> getTopicTasks(Topic topic);
    List<Task> getTopicTasks(Integer topicId);
    Task getTopicTask(Topic topic, Task task);
    Task getTopicTaskByName(Topic topic, String taskLabel);
    Topic addTaskForTopic(Topic topic);
}
