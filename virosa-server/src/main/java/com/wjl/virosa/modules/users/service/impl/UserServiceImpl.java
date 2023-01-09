package com.wjl.virosa.modules.users.service.impl;

import com.wjl.virosa.modules.users.model.entity.User;
import com.wjl.virosa.modules.users.repository.UserRepository;
import com.wjl.virosa.modules.users.service.UserService;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

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

  @Override
  public List<String> selectAllUsernames() {
    return userRepository.findUsernames();
  }

  @Override
  public List<String> selectAllEmails() {
    return userRepository.findEmails();
  }

  @Override
  public User selectByUsernameAndPassword(String username, String password) {
    User user = userRepository.findUserByUsernameAndPassword(username, password);
    return Objects.equals(user, null) ? null : user;
  }

  @Override
  public User selectById(Long id) {
    return userRepository.findById(id).orElse(null);
  }

  @Override
  public boolean add(User user) {
    userRepository.save(user);
    return true;
  }

  @Override
  public boolean update(User user) {
    User newUser = userRepository.findById(user.getId()).orElse(null);
    if (!Objects.equals(newUser, null)) {
      newUser.setToken(user.getToken());
      // TODO: more fields need to update
      userRepository.save(newUser);
      return true;
    }
    return false;
  }

}
