package com.bb.planner.models;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "topic")
public class Topic {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "topic_id")
    private Integer topicId;

    @Column(name = "topic_label")
    private String topicLabel;

    @Column(name = "task_list")
    @OneToMany(mappedBy = "topic")
    private List<Task>  tasks;

    public Topic() {
    }

    public Topic(String topicLabel) {
        this.topicLabel = topicLabel;
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
