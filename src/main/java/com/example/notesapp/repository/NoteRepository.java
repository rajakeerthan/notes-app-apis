package com.example.notesapp.repository;

import com.example.notesapp.model.Note;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository
public interface NoteRepository extends JpaRepository<Note, UUID> {
    List<Note> findByUserId(UUID userId);

    Optional<Note> findByIdAndUserId(UUID id, UUID userId);

    @Transactional
    void deleteByIdAndUserId(UUID id, UUID userId);
}
