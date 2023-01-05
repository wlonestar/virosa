package com.wjl.virosa.modules.posts.model.entity;

import jakarta.persistence.Column;
import jakarta.persistence.*;
import lombok.Data;

import java.io.Serializable;

/**
 * @author <a href="mailto:wlonestar@163.com">wjl</a>
 * @version 0.0.1
 * @time 2023/1/5 20:33
 */
@Data
@Entity
@Table(name = "category")
public class Category implements Serializable {

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

}
