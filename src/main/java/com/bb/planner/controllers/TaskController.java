package com.bb.planner.controllers;

import com.bb.planner.models.Task;
import com.bb.planner.services.TaskService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.ArraySchema;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class TaskController{

    private final TaskService taskService;

    public TaskController(TaskService taskService) {
        this.taskService = taskService;
    }

    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Successful get all request",
                content = { @Content(mediaType = "application/json",
                        array = @ArraySchema(schema = @Schema(implementation = Task.class)))})
    })
    @Operation(summary = "Query all task")
    @GetMapping(path = "/api/tasks", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Task> getAllTask() {
        return taskService.getAllTask();
    }


    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Successful get request",
                content = { @Content(mediaType = "application/json", schema = @Schema(implementation = Task.class))}),
            @ApiResponse(responseCode = "500", description = "Unsuccessful request",
                content = { @Content(mediaType = "application/json")})
    })
    @Operation(summary = "Get one task")
    @GetMapping(path = "/api/tasks/{taskId}", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public Task getTask(
            @Parameter(description = "The id of the task", required = true, example = "1")
            @PathVariable Integer taskId) {
        return taskService.getTaskById(taskId);
    }

    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Successful save request",
                content = { @Content(mediaType = "application/json", schema = @Schema(implementation = Task.class))}),
            @ApiResponse(responseCode = "500", description = "Unsuccessful save request",
                content = { @Content(mediaType = "application/json")})
    })
    @Operation(summary = "Save task")
    @PostMapping(path = "/api/tasks", consumes = MediaType.APPLICATION_JSON_VALUE)
    public Task addTask(
            @Parameter(description = "The new task", required = true)
            @RequestBody Task task) {
        return taskService.addTask(task);
    }

    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Successful delete request",
                content = { @Content(mediaType = "application/json", schema = @Schema(implementation = Task.class))}),
            @ApiResponse(responseCode = "500", description = "Unsuccessful delete request",
                content = { @Content(mediaType = "application/json")})
    })
    @Operation(summary = "Delete task")
    @DeleteMapping("tasks/{taskId}")
    public void deleteTask(
            @Parameter(description = "The id of the task that you would like to delete", required = true, example = "1")
            @PathVariable Integer taskId) {

    }
}
