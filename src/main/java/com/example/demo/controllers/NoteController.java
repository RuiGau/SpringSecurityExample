package com.example.demo.controllers;

import com.example.demo.models.Note;
import com.example.demo.services.NoteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/notes")
public class NoteController {

    @Autowired
    private NoteService noteService;

    @GetMapping("/{id}")
    public Note getOneNote(@PathVariable("id") long id) {
        System.out.println("Request id: " + id);
        Note note = new Note("Title", "Description");
        note.setId(id);
        return note;
    }

    @PostMapping("/")
    public void addNote(@RequestBody Note note) {
        noteService.saveOneNote(note);
    }

    @GetMapping("/")
    public List<Note> getAllNotes() {
        return noteService.getAllNotes();
    }
}
