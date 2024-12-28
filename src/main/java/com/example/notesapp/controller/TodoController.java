package com.example.notesapp.controller;

import com.example.notesapp.model.Todo;
import com.example.notesapp.repository.TodoRepository;
import com.example.notesapp.service.TodoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/todo")
public class TodoController {
    @Autowired
    private TodoService todoService;

    @Autowired
    private TodoRepository todoRepository;

    @GetMapping()
    public ResponseEntity<List<Todo>> getAllToDO(){
        return ResponseEntity.ok(todoService.getAllTodo());
    }

    @PostMapping()
    public ResponseEntity<Todo> createToDO(@RequestBody Todo todo){
        return ResponseEntity.ok(todoService.createTodo(todo));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteToDoByID(@PathVariable UUID id){
        todoService.deletTodoByID(id);
        return ResponseEntity.noContent().build();

    }




}
