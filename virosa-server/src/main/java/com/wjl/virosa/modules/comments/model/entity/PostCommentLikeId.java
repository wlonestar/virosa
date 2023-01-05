package com.wjl.virosa.modules.comments.model.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.Data;

import java.io.Serializable;

/**
 * @author <a href="mailto:wlonestar@163.com">wjl</a>
 * @version 0.0.1
 * @time 2023/1/5 22:12
 */
@Data
@Embeddable
public class PostCommentLikeId implements Serializable {

  @Column(name = "comment_id")
  private Long commentId;

  @Column(name = "user_id")
  private Long userId;

}
