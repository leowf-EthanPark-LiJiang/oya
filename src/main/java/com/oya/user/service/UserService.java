package com.oya.user.service;

import java.util.List;

import com.oya.user.domain.User;
import com.oya.user.dto.UserDto;

/**
 * Created by baiyp on 2016/8/24.
 */
public interface UserService {
   long createUser(UserDto user);

   long updateUserInfo(UserDto user);

   User getUserByUserNameOrEmail(String val);

   User getUserById(long id);

   boolean authenticateUser(String username, String password);

   List<User> getUsers();

}
