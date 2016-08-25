package com.oya.note.repo;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.oya.note.domain.Note;

/**
 * Created by baiyp on 2016/8/24.
 */
public interface NoteRepo extends CrudRepository<Note, Long> {

   @Query("select n from Note as n where n.user.uidPk = ?1")
   List<Note> getNotesByUserId(long userId);
}
