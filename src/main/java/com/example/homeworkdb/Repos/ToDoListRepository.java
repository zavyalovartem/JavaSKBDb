package com.example.homeworkdb.Repos;

import com.example.homeworkdb.models.ToDoListModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ToDoListRepository extends JpaRepository<ToDoListModel, Long> {
}
