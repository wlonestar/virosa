package com.wjl.virosa.modules.users.model.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.Data;

import java.io.Serializable;

/**
 * @author <a href="mailto:wlonestar@163.com">wjl</a>
 * @version 0.0.1
 * @time 2023/1/5 22:31
 */
@Data
@Embeddable
public class UserFollowId implements Serializable {

  @Column(name = "follower_id")
  private Long followerId;

  @Column(name = "followed_id")
  private Long followedId;

}
