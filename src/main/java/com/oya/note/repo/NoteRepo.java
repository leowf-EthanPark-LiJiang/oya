package com.oya.note.repo;

import org.springframework.data.repository.CrudRepository;

import com.oya.note.domain.Note;

/**
 * Created by baiyp on 2016/8/24.
 */
public interface NoteRepo extends CrudRepository<Note, Long> {
}
