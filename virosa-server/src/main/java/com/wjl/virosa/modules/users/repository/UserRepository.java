package com.wjl.virosa.modules.users.repository;

import com.wjl.virosa.modules.users.model.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @author <a href="mailto:wlonestar@163.com">wjl</a>
 * @version 0.0.1
 * @time 2023/1/5 22:55
 */
@Repository
public interface UserRepository extends JpaRepository<User, Long> {
}
