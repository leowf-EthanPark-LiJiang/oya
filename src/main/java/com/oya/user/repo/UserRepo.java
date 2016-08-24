package com.oya.user.repo;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.oya.user.domain.User;

/**
 * Created by baiyp on 2016/8/24.
 */
public interface UserRepo extends CrudRepository<User, Long> {
   @Query("select u from User as u where u.username = :username or u.email = :email")
   User findUserByUsernameOrEmail(@Param("username") String username,
         @Param("email") String email);

   @Query("select u from User as u order by u.uidPk")
   List<User> getAllUsers();
}
