package com.example.notesapp.repository;


import com.example.notesapp.model.Todo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

//public class ToDoRepository {
//
//
//}

@Repository
public interface TodoRepository extends JpaRepository<Todo, UUID> {


}
