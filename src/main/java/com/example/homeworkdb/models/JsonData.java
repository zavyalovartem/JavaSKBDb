package com.example.homeworkdb.models;

import lombok.Data;

import java.util.List;

@Data
public class JsonData {
    public String name;
    public List<String> events;

    public JsonData(String name, List<String> events){
        this.name = name;
        this.events = events;
    }
}
