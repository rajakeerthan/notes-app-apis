package com.example.notesapp.repository;

import com.example.notesapp.model.Note;
import com.example.notesapp.model.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;
import java.util.Optional;

@Repository
//public interface UserRepository extends JpaRepository<Note, UUID> {
//    User findByEmail(String email);
//}

public interface UserRepository extends JpaRepository<Users, UUID> {
    Optional<Users> findById(UUID id);
    Users findByEmail(String email);
}
