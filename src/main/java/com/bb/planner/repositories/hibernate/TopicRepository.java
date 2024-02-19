package com.bb.planner.repositories.hibernate;

import com.bb.planner.models.Task;
import com.bb.planner.models.Topic;

import java.util.List;

public interface TopicRepository extends BaseRepository<Topic, Integer>{

    List<Task> getTopicTasks(Topic topic);
    Task getTopicTask(Topic topic, Task task);
    Task getTopicTaskByName(Topic topic, String taskLabel);
}
