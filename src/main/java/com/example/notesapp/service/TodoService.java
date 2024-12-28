package com.example.notesapp.service;

import com.example.notesapp.dto.TodoDto;
import com.example.notesapp.model.Todo;
import com.example.notesapp.model.Users;
import com.example.notesapp.repository.TodoRepository;
import com.example.notesapp.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class TodoService {

    @Autowired
    private TodoRepository todoRepository;

    @Autowired
    private UserRepository userRepository;

    public List<Todo> getAllTodo() {
        return todoRepository.findAll();
    }


    public Todo createTodo(UUID userId,TodoDto todoDto){
        Todo todo=new Todo();
        Users user=userRepository.findById(userId).orElseThrow(()->new RuntimeException("User not found"));
        todo.setTasks(todoDto.getTasks());
        todo.setStatus(todoDto.isStatus());
        todo.setUser(user);
        return todoRepository.save(todo);
    }


    public List<Todo> getTodoByUserId(UUID userId){
        return todoRepository.findByUserId(userId);
    }


    public void deletTodoByID(UUID id){
        todoRepository.deleteById(id);
    }

}
