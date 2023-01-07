package com.wjl.virosa.modules.posts.model.entity;

import jakarta.persistence.Column;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Data;

import java.io.Serializable;

/**
 * @author <a href="mailto:wlonestar@163.com">wjl</a>
 * @version 0.0.1
 * @time 2023/1/5 22:14
 */
@Data
@Entity
@Table(name = "post_like")
public class PostLike implements Serializable {

  @EmbeddedId
  private PostLikeId id;

  @Column(name = "type")
  private Short type;

}
