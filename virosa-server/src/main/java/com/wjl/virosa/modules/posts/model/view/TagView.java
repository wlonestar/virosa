package com.wjl.virosa.modules.posts.model.view;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;
import org.hibernate.annotations.Immutable;

import java.io.Serializable;

/**
 * @author <a href="mailto:wlonestar@163.com">wjl</a>
 * @version 0.0.1
 * @time 2023/1/6 15:16
 */
@Data
@Entity
@Immutable
@Table(name = "tag_view")
public class TagView implements Serializable {

  @Id
  private Long id;
  private String name;
  private String description;
  private String cover;
  private Long followNum;
  private Long postNum;

}
