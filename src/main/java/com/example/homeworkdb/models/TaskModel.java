package com.example.homeworkdb.models;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.Data;

import javax.persistence.*;

@Data
@Entity
public class TaskModel {
    @Id
    @GeneratedValue
    private Long Id;
    private String task;
    @ManyToOne(fetch = FetchType.LAZY)
    @JsonBackReference
    private ToDoListModel toDoList;
}
