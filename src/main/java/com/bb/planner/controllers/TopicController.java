package com.bb.planner.controllers;

import com.bb.planner.models.Task;
import com.bb.planner.models.Topic;
import com.bb.planner.services.TopicService;
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
@RequestMapping(path = "api/topics")
public class TopicController {

    private final TopicService topicService;

    public TopicController(TopicService topicService) {
        this.topicService = topicService;
    }

    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Successfully got all the topic",
            content = { @Content(mediaType = "application/json",
                    array = @ArraySchema(schema = @Schema(implementation = Topic.class)))})
    })
    @Operation(summary = "Get all the topic")
    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Topic> getAllTopic(){
        return topicService.getAllTopic();
    }

    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Successfully got the topic",
                content = { @Content(mediaType = "application/json", schema = @Schema(implementation = Topic.class))}),
            @ApiResponse(responseCode = "500", description = "Couldn't found the topic",
                content = { @Content(mediaType = "application/json")})
    })
    @Operation(summary = "Get topic by topic id")
    @GetMapping(path = "/{topicId}", produces = MediaType.APPLICATION_JSON_VALUE)
    public Topic getTopicById(
            @Parameter(description = "The id of the topic", required = true, example = "1")
            @PathVariable Integer topicId){
        return topicService.getTopicById(topicId);
    }

    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Successfully saved the topic",
                content = { @Content(mediaType = "application/json", schema = @Schema(implementation = Topic.class))}),
            @ApiResponse(responseCode = "500", description = "Couldn't save the topic",
                content = { @Content(mediaType = "application/json")})
    })
    @Operation(summary = "Save topic")
    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public Topic saveTopic(
            @Parameter(description = "The new topic", required = true)
            @RequestBody Topic topic){
        return topicService.addTopic(topic);
    }

    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Successfully saved the task for the topic",
                    content = { @Content(mediaType = "application/json", schema = @Schema(implementation = Topic.class))}),
            @ApiResponse(responseCode = "500", description = "Couldn't saved the task for the topic",
                    content = { @Content(mediaType = "application/json")})
    })
    @Operation(summary = "Save task for the chosen topic")
    @PutMapping(path = "/{topicId}")
    public Topic saveTaskForTopic(
            @PathVariable Integer topicId,
            @RequestBody Task task
    ){
        return topicService.saveTaskForTopic(topicId, task);
    }

    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Successfully got all the task from the topic",
                    content = { @Content(mediaType = "application/json", array = @ArraySchema(schema = @Schema(implementation = Task.class)))}),
            @ApiResponse(responseCode = "500", description = "Couldn't found the topic or couldn't get the tasks",
                    content = { @Content(mediaType = "application/json")})
    })
    @Operation(summary = "Get all task from topic")
    @GetMapping(path = "/{topicId}/tasks", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Task> getTasksFromTopicById(
            @Parameter(description = "The id of the topic", required = true, example = "1")
            @PathVariable Integer topicId){
        return topicService.getAllTaskFromTopicById(topicId);
    }

    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Successfully deleted the topic",
                    content = { @Content(mediaType = "application/json")}),
            @ApiResponse(responseCode = "500", description = "Couldn't deleted the topic",
                    content = { @Content(mediaType = "application/json")})
    })
    @Operation(summary = "Delete a topic with topic ID")
    @DeleteMapping(path = "/{topicId}", produces = MediaType.APPLICATION_JSON_VALUE)
    public void deleteTopicById(
            @Parameter(description = "The id of the topic", required = true, example = "1")
            @PathVariable Integer topicId
    ){
        topicService.deleteTopicById(topicId);
    }
}
