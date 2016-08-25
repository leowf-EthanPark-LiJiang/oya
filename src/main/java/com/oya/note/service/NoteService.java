package com.oya.note.service;

import java.util.List;
import java.util.Map;

import com.oya.note.domain.Note;

/**
 * Created by baiyp on 2016/8/25.
 */
public interface NoteService {

   long saveNote(Note note);

   Map<Integer, List<Note>> getNotesByUserId(long uid);
}
