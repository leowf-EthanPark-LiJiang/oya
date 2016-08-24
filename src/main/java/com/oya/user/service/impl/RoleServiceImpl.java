package com.oya.user.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.oya.user.constant.RoleNameConstant;
import com.oya.user.domain.Role;
import com.oya.user.repo.RoleRepo;
import com.oya.user.service.RoleService;


/**
 * Author: EthanPark <br/>
 * Date: 2015/11/18<br/>
 * Email: byp5303628@hotmail.com
 */
@Service
public class RoleServiceImpl implements RoleService {
   @Autowired
   private RoleRepo roleRepository;

   public Role getUserRole() {
      return roleRepository.getRoleByName(RoleNameConstant.USER_ROLE_NAME);
   }

   public Role getAdminRole() {
      return roleRepository.getRoleByName(RoleNameConstant.ADMIN_ROLE_NAME);
   }

   public Role getGuestRole() {
      return roleRepository.getRoleByName(RoleNameConstant.GUEST_ROLE_NAME);
   }
}
