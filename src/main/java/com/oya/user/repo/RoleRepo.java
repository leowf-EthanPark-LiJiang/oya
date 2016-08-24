package com.oya.user.repo;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.Repository;
import org.springframework.data.repository.query.Param;

import com.oya.user.domain.Role;

/**
 * Created by baiyp on 2016/8/24.
 */
public interface RoleRepo extends Repository<Role, Long> {
   @Query("select r from Role as r where r.roleName = :name")
   Role getRoleByName(@Param("name") String name);
}
