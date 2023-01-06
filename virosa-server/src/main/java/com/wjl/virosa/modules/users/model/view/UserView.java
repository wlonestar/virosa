package com.wjl.virosa.modules.users.model.view;

import jakarta.persistence.Id;

import java.io.Serializable;

/**
 * @author <a href="mailto:wlonestar@163.com">wjl</a>
 * @version 0.0.1
 * @time 2023/1/6 15:18
 */
public class UserView implements Serializable {

  @Id
  private Long id;
  private String username;
  private String password;
  private String email;
  private String avatar;
  private String bio;
  private String homepage;
  private String intro;
  private String joinTime;
  private Long followerNum;
  private Long followedNum;
  private Long postLikeNum;

}
