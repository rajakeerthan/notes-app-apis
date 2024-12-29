package com.example.notesapp.repository;


import com.example.notesapp.model.Note;
import com.example.notesapp.model.Todo;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;



@Repository
public interface TodoRepository extends JpaRepository<Todo, UUID> {
    List<Todo> findByUserId(UUID userId);

    @Transactional
    void deleteByIdAndUserId(UUID id, UUID userId);
    Optional<Todo> findByIdAndUserId(UUID id, UUID userId);


}
