package com.wjl.virosa.modules.posts.model.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.io.Serializable;
import java.time.Instant;

/**
 * @author <a href="mailto:wlonestar@163.com">wjl</a>
 * @version 0.0.1
 * @time 2023/1/5 21:00
 */
@Data
@Entity
@Table(name = "column")
public class Column implements Serializable {

  @Id
  @jakarta.persistence.Column(name = "id")
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @jakarta.persistence.Column(name = "name")
  private String name;

  @jakarta.persistence.Column(name = "cover")
  private String cover;

  @jakarta.persistence.Column(name = "description")
  private String description;

  @jakarta.persistence.Column(name = "create_time")
  private Instant createTime;

  @jakarta.persistence.Column(name = "update_time")
  private Instant updateTime;

}
