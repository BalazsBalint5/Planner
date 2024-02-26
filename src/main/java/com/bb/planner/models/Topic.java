package com.bb.planner.models;

import jakarta.persistence.*;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "topic")
public class Topic {

    @Id
    @GeneratedValue(generator = "topic_sequence")
    @GenericGenerator(
            name = "topic_sequence",
            type = org.hibernate.id.enhanced.SequenceStyleGenerator.class,
            parameters = {
                    @Parameter(name = "sequence_name", value = "topic_sequence"),
                    @Parameter(name = "initial_value", value = "161"),
                    @Parameter(name = "increment_value", value = "1"),
            }
    )
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
    @OneToMany(mappedBy = "topic", cascade = {CascadeType.PERSIST, CascadeType.MERGE, CascadeType.REMOVE})
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

    public void addTask(Task task){
        task.setTopic(this);
        tasks.add(task);
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
