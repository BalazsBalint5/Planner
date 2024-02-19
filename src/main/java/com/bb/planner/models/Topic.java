package com.bb.planner.models;

import jakarta.persistence.*;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "topic")
public class Topic {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "topic_id")
    @NotNull(message = "Topic id can't be null")
    @Min(message = "Topic id must be greater then 0", value = 1)
    private Integer topicId;

    @Column(name = "topic_label")
    @NotNull(message = "Topic label can't be null")
    @NotBlank(message = "Topic label can't be blank")
    @NotEmpty(message = "Topic label can't be empty")
    private String topicLabel;

    @Column(name = "task_list")
    @OneToMany(mappedBy = "topic")
    private List<Task>  tasks;

    public Topic() {
    }

    public Topic(String topicLabel) {
        this.topicLabel = topicLabel;
        this.tasks = new ArrayList<>();
    }

    public Integer getTopicId() {
        return topicId;
    }

    public String getTopicLabel() {
        return topicLabel;
    }

    public List<Task> getTasks() {
        return tasks;
    }

    @Override
    public String toString() {
        return "Topic{" +
                "topicId=" + topicId +
                ", topicLabel='" + topicLabel + '\'' +
                ", tasks=" + tasks +
                '}';
    }
}
