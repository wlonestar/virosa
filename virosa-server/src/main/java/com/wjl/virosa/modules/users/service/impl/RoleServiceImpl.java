package com.wjl.virosa.modules.users.service.impl;

import com.wjl.virosa.modules.users.model.entity.Role;
import com.wjl.virosa.modules.users.repository.RoleRepository;
import com.wjl.virosa.modules.users.service.RoleService;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author <a href="mailto:wlonestar@163.com">wjl</a>
 * @version 0.0.1
 * @time 2023/1/9 20:37
 */
@Service
public class RoleServiceImpl implements RoleService {

  @Resource
  private RoleRepository roleRepository;

  @Override
  public List<Role> selectAll() {
    return roleRepository.findAll();
  }

  @Override
  public List<String> selectAllRoleName() {
    return roleRepository.findRoleNames();
  }

  @Override
  public Role selectById(Long id) {
    return roleRepository.findById(id).orElse(null);
  }

}
