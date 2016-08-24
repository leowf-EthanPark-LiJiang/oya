package com.oya.note.domain;

import com.oya.user.domain.User;

import javax.persistence.*;

/**
 * Created by baiyp on 2016/8/24.
 */
@Entity
@Table(name = Note.TABLE_NAME)
public class Note {
   public static final String TABLE_NAME = "NOTE";

   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   @Column(name = "UIDPK")
   private long uidPk;

   private User user;

   private int type;

   private String prizeGrade;

   private String prizeDesc;

}
