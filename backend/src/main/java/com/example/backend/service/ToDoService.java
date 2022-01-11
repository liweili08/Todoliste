package com.example.backend.service;

import com.example.backend.model.ToDo;
import com.example.backend.repository.ToDoRepo;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ToDoService {
    private final ToDoRepo toDoRepo;
    private final IdService idService;

    public ToDoService(ToDoRepo toDoRepo, IdService idService) {
        this.toDoRepo = toDoRepo;
        this.idService = idService;
    }

    public List<ToDo> allTodos() {
        return toDoRepo.getAllToDos();
    }

    public ToDo addTodo(ToDo toDoToAdd) {
        toDoToAdd.setId(idService.generateId());
        return toDoRepo.saveToDo(toDoToAdd);
    }

    public Optional<ToDo> findToDoById(String id) {
        return toDoRepo.findById(id);
    }
}
