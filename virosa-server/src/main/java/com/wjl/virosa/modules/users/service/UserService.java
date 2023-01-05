package com.wjl.virosa.modules.users.service;

import com.wjl.virosa.modules.users.model.entity.User;

import java.util.List;

/**
 * @author <a href="mailto:wlonestar@163.com">wjl</a>
 * @version 0.0.1
 * @time 2023/1/5 22:55
 */
public interface UserService {

  List<User> selectAll();

}
