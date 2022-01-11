package com.example.backend.repository;

import com.example.backend.model.ToDo;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@Repository
public class ToDoRepo {
    private final Map<String, ToDo> toDoRepo;

    public ToDoRepo(){
        toDoRepo=new HashMap<>();
        toDoRepo.put("1", ToDo.builder().id("1").description("Erstes ToDo").status("OPEN").build());
        toDoRepo.put("2", ToDo.builder().id("2").description("Noch ein ToDo").status("IN_PROGRESS").build());
        toDoRepo.put("3", ToDo.builder().id("3").description("Fertiges ToDo").status("DONE").build());
    }

    public List<ToDo> getAllToDos() {
        return toDoRepo.values().stream().toList();
    }

    public ToDo saveToDo(ToDo toDoToAdd) {
        toDoRepo.put(toDoToAdd.getId(),toDoToAdd);
        return toDoToAdd;
    }

    public Optional<ToDo> findById(String id) {
        return Optional.of(toDoRepo.get(id));
    }


    public ToDo changeToDo(String id, ToDo changedToDo) {
        toDoRepo.replace(id,changedToDo);
        return changedToDo;
    }

    public Optional<ToDo> deleteToDoById(String id) {
        return Optional.of(toDoRepo.remove(id));
    }
}
