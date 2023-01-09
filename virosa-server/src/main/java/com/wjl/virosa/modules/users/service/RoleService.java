package com.wjl.virosa.modules.users.service;

import com.wjl.virosa.modules.users.model.entity.Role;

import java.util.List;

/**
 * @author <a href="mailto:wlonestar@163.com">wjl</a>
 * @version 0.0.1
 * @time 2023/1/9 20:37
 */
public interface RoleService {

  List<Role> selectAll();

  List<String> selectAllRoleName();

  Role selectById(Long id);

}
