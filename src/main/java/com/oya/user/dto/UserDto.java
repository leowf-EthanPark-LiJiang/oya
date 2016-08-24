package com.oya.user.dto;

import com.oya.common.dto.Dto;

/**
 * Created by baiyp on 2016/8/24.
 */
public class UserDto implements Dto {
   private long userId;
   private String username;
   private String password;
   private String email;

   public long getUserId() {
      return userId;
   }

   public void setUserId(long userId) {
      this.userId = userId;
   }

   public String getUsername() {
      return username;
   }

   public void setUsername(String username) {
      this.username = username;
   }

   public String getPassword() {
      return password;
   }

   public void setPassword(String password) {
      this.password = password;
   }

   public String getEmail() {
      return email;
   }

   public void setEmail(String email) {
      this.email = email;
   }
}
