package com.bb.planner.services;

import com.bb.planner.models.Task;

import java.util.List;

public interface TaskService {

    Task getTask(Task task);
    Task getTaskById(Integer taskId);
    List<Task> getAllTask();
    void addTask(Task task);
    void deleteTask(Task task);

}
