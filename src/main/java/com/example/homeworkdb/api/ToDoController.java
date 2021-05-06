package com.example.homeworkdb.api;

import com.example.homeworkdb.Repos.ToDoListRepository;
import com.example.homeworkdb.models.JsonData;
import com.example.homeworkdb.models.TaskModel;
import com.example.homeworkdb.models.ToDoListModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/todotest")
public class ToDoController {

    @Autowired
    private ToDoListRepository toDoListRepository;

    @PostMapping("/insert")
    public void InsertIntoDb(@RequestBody JsonData toDoList){
        ToDoListModel list = new ToDoListModel();
        ArrayList<TaskModel> events = new ArrayList<>();
        toDoList.events.forEach(event ->{
            TaskModel task = new TaskModel();
            task.setTask(event);
            task.setToDoList(list);
            events.add(task);
        });
        list.setEvents(events);
        list.setName(toDoList.getName());
        toDoListRepository.save(list);
    }

    @GetMapping("/displayAll")
    public ArrayList<JsonData> DisplayLists(){
        ArrayList<ToDoListModel> entities = (ArrayList<ToDoListModel>) toDoListRepository.findAll();
        var result = new ArrayList<JsonData>();
        entities.stream().forEach(entity ->
        {
            result.add(new JsonData(entity.getName(), entity.getEvents().stream().map(event -> event.getTask())
            .collect(Collectors.toList())));
        });
        return result;
    }
}
