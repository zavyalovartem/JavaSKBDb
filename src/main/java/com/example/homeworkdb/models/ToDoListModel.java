package com.example.homeworkdb.models;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.Data;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Data
@Entity(name="list")
public class ToDoListModel {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Long Id;
    public String name;
    @OneToMany(mappedBy = "toDoList", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.LAZY)
    @JsonManagedReference
    public List<TaskModel> events;

    public ToDoListModel(String name, ArrayList<TaskModel> events) {
        this.name = name;
        this.events = events;
    }

    public ToDoListModel(){
        this.name = "DefaultToDoList";
        this.events = new ArrayList<>();
    }
}
