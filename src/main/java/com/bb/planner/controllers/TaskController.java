package com.bb.planner.controllers;

import com.bb.planner.models.Task;
import com.bb.planner.services.TaskService;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class TaskController{

    private final TaskService taskService;

    public TaskController(TaskService taskService) {
        this.taskService = taskService;
    }

    @GetMapping(path = "/api/tasks", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Task> getAllTask() {
        return taskService.getAllTask();
    }

    @GetMapping(path = "/api/tasks/{taskId}", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public Task getTask(@PathVariable Integer taskId) {
        return taskService.getTaskById(taskId);
    }

    @PostMapping(path = "/api/tasks", consumes = MediaType.APPLICATION_JSON_VALUE)
    public void addTask(@RequestBody Task task) {
        System.out.println(task.getTaskLabel());
        //taskService.addTask(task);
    }

    @DeleteMapping("tasks/{taskId}")
    public void deleteTask(@PathVariable Integer taskId) {

    }
}
