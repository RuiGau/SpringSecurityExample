package com.example.demo.services;

import com.example.demo.data_access.NoteRepository;
import com.example.demo.models.Note;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class NoteService {

    @Autowired
    private NoteRepository noteRepository;

    public Note getNoteById (Long id) {
        return noteRepository.findOne(id);
    }

    public List<Note> getAllNotes() {
        return noteRepository.findAll();
    }

    public void saveOneNote(Note note) {
        noteRepository.save(note);
    }

}
