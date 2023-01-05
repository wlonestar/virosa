package com.wjl.virosa.modules.comments.model.entity;

import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Data;

import java.io.Serializable;

/**
 * @author <a href="mailto:wlonestar@163.com">wjl</a>
 * @version 0.0.1
 * @time 2023/1/5 22:12
 */
@Data
@Entity
@Table(name = "post_comment_like")
public class PostCommentLike implements Serializable {

  @EmbeddedId
  private PostCommentLikeId id;

}
