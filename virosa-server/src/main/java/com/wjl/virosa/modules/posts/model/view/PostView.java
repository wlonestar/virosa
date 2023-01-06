package com.wjl.virosa.modules.posts.model.view;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;
import org.hibernate.annotations.Immutable;

import java.io.Serializable;
import java.time.Instant;

/**
 * @author <a href="mailto:wlonestar@163.com">wjl</a>
 * @version 0.0.1
 * @time 2023/1/6 15:11
 */
@Data
@Entity
@Immutable
@Table(name = "post_view")
public class PostView implements Serializable {

  @Id
  private Long id;
  private String title;
  private String summary;
  private String cover;
  private String content;
  private Instant createTime;
  private Instant updateTime;
  private Long cateId;
  private Long authorId;
  private Long likeNum;

}
