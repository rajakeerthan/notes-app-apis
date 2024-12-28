package com.example.notesapp.service;

import com.example.notesapp.dto.NotesDto;
import com.example.notesapp.model.Note;
import com.example.notesapp.model.Users;
import com.example.notesapp.repository.NoteRepository;
import com.example.notesapp.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.util.List;
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
//        User user=userRepository.findById(userId).orElseThrow(()-> new RuntimeException("User not found"));
        Users user = userRepository.findById(userId).orElseThrow(() -> new RuntimeException("User not found"));
        Note note = new Note();
        note.setCreatedBy(notesDto.getCreatedBy());
        note.setDescription(notesDto.getDescription());
        Timestamp timestamp = new Timestamp(System.currentTimeMillis());
        note.setTimestamp(timestamp);
        note.setUser(user);
        return noteRepository.save(note);
    }


    public List<Note> getNotesByUserId(UUID userId){
        return noteRepository.findByUserId(userId);
    }
    public void deleteNoteById(UUID id) {
        noteRepository.deleteById(id);
    }
}
