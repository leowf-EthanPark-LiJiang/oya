package com.oya.user.domain;

import javax.persistence.*;

/**
 * Created by baiyp on 2016/8/24.
 */
@Entity
@Table(name = Role.TABLE_NAME)
public class Role {
   public static final String TABLE_NAME = "ROLE";

   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   @Column(name = "UIDPK")
   private long uidPk;

   @Basic
   @Column(name = "ROLE_NAME")
   private String roleName;

   @Basic
   @Column(name = "PRIORITY")
   private int priority;

   public int getPriority() {
      return priority;
   }

   public void setPriority(int priority) {
      this.priority = priority;
   }

   public long getUidPk() {
      return uidPk;
   }

   public void setUidPk(long uidPk) {
      this.uidPk = uidPk;
   }

   public String getRoleName() {
      return roleName;
   }

   public void setRoleName(String roleName) {
      this.roleName = roleName;
   }
}

