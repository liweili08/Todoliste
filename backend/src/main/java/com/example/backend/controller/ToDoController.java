package com.example.backend.controller;

import com.example.backend.model.ToDo;
import com.example.backend.service.ToDoService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

import static org.springframework.http.ResponseEntity.ok;

@RestController
@RequestMapping("/api/todo")
public class ToDoController {
    private final ToDoService toDoService;

    public ToDoController(ToDoService toDoService) {
        this.toDoService = toDoService;
    }

    @GetMapping
    public ResponseEntity<List<ToDo>> getAllTodos(){
        List<ToDo> allTodos =toDoService.allTodos();
        return ok(allTodos);
    }

    @PostMapping
    public ResponseEntity<ToDo> postNewToDo(@RequestBody ToDo toDoToAdd){
//        /*ToDo addedToDo=todoservice.addToDo(toDoAdd);
//        return ok(addedToDo);*/
        return ok(toDoService.addTodo(toDoToAdd));
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<ToDo> getToDoById(@PathVariable String id){
       Optional<ToDo> optToDo = toDoService.findToDoById(id);
       return ResponseEntity.of(optToDo);
    }

    @PutMapping(value = "/{id}/update")
    public ResponseEntity<ToDo> putUpdateToDo(@RequestBody ToDo changedToDo){
        Optional<ToDo> optToDo= toDoService.updateToDo(changedToDo);
        return ResponseEntity.of(optToDo);
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<ToDo> putNewStatus(@RequestBody ToDo changedToDo){
        Optional<ToDo> optToDo= toDoService.updateToDo(changedToDo);
        return ResponseEntity.of(optToDo);
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<ToDo> deleteToDo(@PathVariable String id){
        Optional<ToDo> optToDo =  toDoService.removeToDoById(id);
        return ResponseEntity.of(optToDo);
    }



}
