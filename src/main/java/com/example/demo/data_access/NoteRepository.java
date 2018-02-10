package com.example.demo.data_access;

import com.example.demo.models.Note;
import org.springframework.data.domain.Page;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.List;

public interface NoteRepository extends PagingAndSortingRepository<Note, Long> {
    public List<Note> findAll();
}
