package com.oya.user.service;

import com.oya.user.domain.Role;

/**
 * Author: EthanPark <br/>
 * Date: 2015/11/18<br/>
 * Email: byp5303628@hotmail.com
 */
public interface RoleService {
   Role getUserRole();

   Role getAdminRole();

   Role getGuestRole();
}
