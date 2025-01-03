package com.example.notesapp.controller;

import com.example.notesapp.dto.TodoDto;

import com.example.notesapp.model.Todo;
import com.example.notesapp.repository.TodoRepository;
import com.example.notesapp.service.TodoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
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


    @PutMapping("/update/{id}")
    public ResponseEntity<Todo> updateTodo(@PathVariable UUID id,@RequestParam UUID userId,@RequestBody TodoDto updatedTodoDto){
        Todo updatedToDo = todoService.createTodo(userId, updatedTodoDto);
        return new ResponseEntity<>(updatedToDo, HttpStatus.CREATED);
        //return new ResponseEntity<>(todoService.updateTodo(id,userId,updatedTodoDto));

    }
    //TODO: Delete mapping

    @DeleteMapping("/delete-todo")
    public ResponseEntity<String> deleteDto(@RequestParam UUID id,@RequestParam UUID userId){
        todoService.deleteTodoByIdandUserId(id,userId);
        return ResponseEntity.ok("deleted successfully");
    }
    @PostMapping("/create-todo/{userId}")
    public ResponseEntity<Todo> createToDo(@PathVariable UUID userId, @RequestBody TodoDto toDoDTO) {
        Todo createdToDo = todoService.createTodo(userId, toDoDTO);
        return new ResponseEntity<>(createdToDo, HttpStatus.CREATED);
    }

    @GetMapping("/get-all-todo/{userId}")
    public ResponseEntity<List<Todo>> getTodosByUserId(@PathVariable UUID userId) {
        List<Todo> toDos = todoService.getTodoByUserId(userId);
        return new ResponseEntity<>(toDos, HttpStatus.OK);
    }


}
