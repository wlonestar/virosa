package com.wjl.virosa.modules.users.service.impl;

import com.wjl.virosa.modules.users.model.entity.User;
import com.wjl.virosa.modules.users.repository.UserRepository;
import com.wjl.virosa.modules.users.service.UserService;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author <a href="mailto:wlonestar@163.com">wjl</a>
 * @version 0.0.1
 * @time 2023/1/5 22:56
 */
@Service
public class UserServiceImpl implements UserService {

  @Resource
  private UserRepository userRepository;

  @Override
  public List<User> selectAll() {
    return userRepository.findAll();
  }

}
