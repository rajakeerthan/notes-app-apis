package com.example.notesapp.service;

import com.example.notesapp.model.Todo;
import com.example.notesapp.repository.TodoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class TodoService {

    @Autowired
    private TodoRepository todoRepository;


    public List<Todo> getAllTodo() {
        return todoRepository.findAll();
    }


    public Todo createTodo(Todo toDo){
        return todoRepository.save(toDo);
    }

    public void deletTodoByID(UUID id){
        todoRepository.deleteById(id);
    }
}
