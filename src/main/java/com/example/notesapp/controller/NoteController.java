package com.example.notesapp.controller;

import com.example.notesapp.dto.NotesDto;
import com.example.notesapp.model.Note;
import com.example.notesapp.repository.NoteRepository;
import com.example.notesapp.service.NoteService;
import org.springframework.beans.factory.annotation.Autowired;
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

    @GetMapping("/get-all-notes")
    public ResponseEntity<List<Note>> getAllNotes() {

        return ResponseEntity.ok(noteService.getAllNotes());
    }

    @PostMapping("/create-note")
    public ResponseEntity<Note> createNote(@RequestBody NotesDto notesDto) {
        return ResponseEntity.ok(noteService.createNote(notesDto));
    }

    @DeleteMapping("/delete-note")
    public ResponseEntity<Void> deleteNoteById(@RequestParam("id") UUID id){
        noteService.deleteNoteById(id);
        return ResponseEntity.ok().build();
    }
}
