package com.example.notesapp.controller;

import com.example.notesapp.dto.NotesDto;
import com.example.notesapp.model.Note;
import com.example.notesapp.repository.NoteRepository;
import com.example.notesapp.service.NoteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/notes")
public class NoteController {

    @Autowired
    private NoteService noteService;

    @Autowired
    private NoteRepository noteRepository;

//    public NoteController(NoteService noteService) {
//        this.noteService = noteService;
//    }
//
//    @GetMapping("/get-all-notes")
//    public ResponseEntity<List<Note>> getAllNotes() {
//
//        return ResponseEntity.ok(noteService.getAllNotes());
//    }
//



    @PostMapping("/create-notes/{userId}")
    public ResponseEntity<Note> createNote(@PathVariable UUID userId,@RequestBody NotesDto noteDto){
        Note createdNote=noteService.createNote(userId,noteDto);
        return new ResponseEntity<>(createdNote, HttpStatus.CREATED);

    }

    // Fetches all notes associated with the particular user .
    @GetMapping("/get-all-notes/{userId}")
    public ResponseEntity<List<Note>> getNotesByUserId(@PathVariable UUID userId) {
        List<Note> notes = noteService.getNotesByUserId(userId);
        return new ResponseEntity<>(notes, HttpStatus.OK);
    }



}
