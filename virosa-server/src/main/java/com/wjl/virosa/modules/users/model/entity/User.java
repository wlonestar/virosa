package com.wjl.virosa.modules.users.model.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.io.Serializable;
import java.time.Instant;

/**
 * @author <a href="mailto:wlonestar@163.com">wjl</a>
 * @version 0.0.1
 * @time 2023/1/5 22:18
 */
@Data
@Entity
@Table(name = "sys_user")
public class User implements Serializable {

  @Id
  @Column(name = "id")
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @Column(name = "username")
  private String username;

  @Column(name = "password")
  private String password;

  @Column(name = "email")
  private String email;

  @Column(name = "avatar")
  private String avatar;

  @Column(name = "bio")
  private String bio;

  @Column(name = "homepage")
  private String homepage;

  @Column(name = "intro")
  private String intro;

  @Column(name = "join_time")
  private Instant joinTime;

  @Column(name = "role_id")
  private Long roleId;

}
