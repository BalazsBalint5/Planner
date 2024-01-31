package com.bb.planner.services;

import com.bb.planner.models.Task;
import com.bb.planner.repositories.own.TaskRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TaskServiceImpl implements TaskService{

    private final TaskRepository taskRepository;

    public TaskServiceImpl(TaskRepository taskRepository) {
        this.taskRepository = taskRepository;
    }

    @Override
    public Task getTask(Task task) {
        return taskRepository.get(task);
    }

    @Override
    public Task getTaskById(Integer taskId) {
        return taskRepository.getById(taskId);
    }

    @Override
    public List<Task> getAllTask() {
        return taskRepository.getAll();
    }

    @Override
    public void addTask(Task task) {
        taskRepository.add(task);
    }

    @Override
    public void deleteTask(Task task) {
        taskRepository.delete(task);
    }
}
