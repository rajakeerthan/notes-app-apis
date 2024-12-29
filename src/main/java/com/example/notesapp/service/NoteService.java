package com.example.notesapp.service;

import com.example.notesapp.dto.NotesDto;
import com.example.notesapp.model.Note;
import com.example.notesapp.model.Users;
import com.example.notesapp.repository.NoteRepository;
import com.example.notesapp.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.UUID;
import java.util.Optional;
import java.util.function.Supplier;


@Service
public class NoteService {

    @Autowired
    private NoteRepository noteRepository;
    // private  final NoteRepository noteRepository;
    //    public NoteService(NoteRepository noteRepository) {
    //        this.noteRepository = noteRepository;
    //    }

    @Autowired UserRepository userRepository;
//    public List<Note> getAllNotes() {
//        return noteRepository.findAll();
//    }

    public Note createNote(UUID userId,NotesDto notesDto) {
        Users user = userRepository.findById(userId).orElseThrow(() -> new RuntimeException("User not found"));
        Note note = new Note();
        note.setCreatedBy(notesDto.getCreatedBy());
        note.setDescription(notesDto.getDescription());
        Timestamp timestamp = new Timestamp(System.currentTimeMillis());
        note.setTimestamp(timestamp);
        note.setUser(user);
        return noteRepository.save(note);
    }

    //TODO: implement delete functionality
    public void deleteNoteByIdandUserId(UUID id,UUID userId){
        noteRepository.deleteByIdAndUserId(id,userId);
//        if (noteRepository.findByIdAndUserId(id, userId)) {
//            noteRepository.deleteByIdAndUserId(id, userId);
//        } else {
//            throw new NoSuchElementException("Note with ID " + id + " and User ID " + userId + " not found.");
//        }
    }

    public Note updateNote(UUID id, UUID userId, NotesDto updatedNoteDto) {
        Note existingNote = noteRepository.findByIdAndUserId(id, userId)
                .orElseThrow(() -> new RuntimeException("Note not found or you don't have permission to edit it"));

        existingNote.setDescription(updatedNoteDto.getDescription());
        existingNote.setCreatedBy(updatedNoteDto.getCreatedBy());

        return noteRepository.save(existingNote);
    }

    public List<Note> getNotesByUserId(UUID userId)
    {
        return noteRepository.findByUserId(userId);
    }
    public void deleteNoteById(UUID id) {

        noteRepository.deleteById(id);
    }
}
