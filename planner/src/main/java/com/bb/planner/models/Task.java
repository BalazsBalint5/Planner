package com.bb.planner.models;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@Table(name = "task")
public class Task {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "task_id")
    private Integer taskId;

    @Column(name = "task_label")
    private String taskLabel;

    @Column(name = "task_description")
    private String taskDescription;

    @Column(name = "created_at")
    private LocalDate createdAt;

    @Column(name = "status")
    private Status status;

    public Task(String taskLabel, String taskDescription, LocalDate createdAt, Status status) {
        this.taskLabel = taskLabel;
        this.taskDescription = taskDescription;
        this.createdAt = createdAt;
        this.status = status;
    }

    public Integer getTaskId() {
        return taskId;
    }

    public String getTaskLabel() {
        return taskLabel;
    }

    public String getTaskDescription() {
        return taskDescription;
    }

    public LocalDate getCreatedAt() {
        return createdAt;
    }

    @Override
    public String toString() {
        return "Task{" +
                "taskId=" + taskId +
                ", taskLabel='" + taskLabel + '\'' +
                ", taskDescription='" + taskDescription + '\'' +
                ", createdAt=" + createdAt +
                '}';
    }
}
