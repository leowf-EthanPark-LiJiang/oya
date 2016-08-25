package com.oya.note.service.impl;

import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.oya.note.domain.Note;
import com.oya.note.repo.NoteRepo;
import com.oya.note.service.NoteService;

/**
 * Created by baiyp on 2016/8/25.
 */
@Service
public class NoteServiceImpl implements NoteService {
   @Autowired
   private NoteRepo noteRepo;

   @Override
   public long saveNote(Note note) {
      return noteRepo.save(note).getUidPk();
   }

   @Override
   public Map<Integer, List<Note>> getNotesByUserId(long uid) {
      List<Note> notes = noteRepo.getNotesByUserId(uid);

      if (notes.isEmpty())
         return Collections.emptyMap();

      Map<Integer, List<Note>> map = new HashMap<>();
      for (Note note : notes) {
         if (!map.containsKey(note.getType())) {
            map.put(note.getType(), new ArrayList<>());
         }
         map.get(note.getType()).add(note);
      }
      return map;
   }
}
