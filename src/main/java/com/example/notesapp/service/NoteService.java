package com.example.notesapp.service;

import com.example.notesapp.dto.NotesDto;
import com.example.notesapp.model.Note;
import com.example.notesapp.repository.NoteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.util.List;

@Service
public class NoteService {

    @Autowired
    private NoteRepository noteRepository;
    // private  final NoteRepository noteRepository;
    //    public NoteService(NoteRepository noteRepository) {
        //        this.noteRepository = noteRepository;
    //    }

    public List<Note> getAllNotes() {
        return noteRepository.findAll();
    }

    public Note createNote(NotesDto notesDto) {
        Note note = new Note();
        note.setCreatedBy(notesDto.getCreatedBy());
        note.setDescription(notesDto.getDescription());
        Timestamp timestamp = new Timestamp(System.currentTimeMillis());
        note.setTimestamp(timestamp);
        return noteRepository.save(note);
    }

    public void deleteNoteById(Long id) {
        noteRepository.deleteById(id);
    }
}
