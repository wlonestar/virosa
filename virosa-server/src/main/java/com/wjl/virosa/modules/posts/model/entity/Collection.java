package com.wjl.virosa.modules.posts.model.entity;

import jakarta.persistence.Column;
import jakarta.persistence.*;
import lombok.Data;

import java.io.Serializable;
import java.time.Instant;

/**
 * @author <a href="mailto:wlonestar@163.com">wjl</a>
 * @version 0.0.1
 * @time 2023/1/5 20:35
 */
@Data
@Entity
@Table(name = "collection")
public class Collection implements Serializable {

  @Id
  @Column(name = "id")
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @Column(name = "name")
  private String name;

  @Column(name = "cover")
  private String cover;

  @Column(name = "description")
  private String description;

  @Column(name = "create_time")
  private Instant createTime;

  @Column(name = "update_time")
  private Instant updateTime;

}
