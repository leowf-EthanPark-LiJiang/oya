package com.oya.security;

import javax.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import com.oya.user.service.UserService;

/**
 * Created by baiyp on 2016/8/24.
 */
public class MyUserDetailService implements UserDetailsService {
   @Autowired
   private UserService userService;

   public UserDetails loadUserByUsername(String username) {
      try {
         return userService.getUserByUserNameOrEmail(username);
      } catch (EntityNotFoundException e) {
         throw new UsernameNotFoundException(
               String.format("Username : \"%s\"", username), e);
      }
   }
}
