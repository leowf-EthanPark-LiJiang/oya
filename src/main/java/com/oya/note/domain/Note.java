package com.oya.note.domain;

import javax.persistence.*;

import com.oya.user.domain.User;

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

   public long getUidPk() {
      return uidPk;
   }

   public void setUidPk(long uidPk) {
      this.uidPk = uidPk;
   }

   public User getUser() {
      return user;
   }

   public void setUser(User user) {
      this.user = user;
   }

   public int getType() {
      return type;
   }

   public void setType(int type) {
      this.type = type;
   }

   public String getPrizeGrade() {
      return prizeGrade;
   }

   public void setPrizeGrade(String prizeGrade) {
      this.prizeGrade = prizeGrade;
   }

   public String getPrizeDesc() {
      return prizeDesc;
   }

   public void setPrizeDesc(String prizeDesc) {
      this.prizeDesc = prizeDesc;
   }
}
