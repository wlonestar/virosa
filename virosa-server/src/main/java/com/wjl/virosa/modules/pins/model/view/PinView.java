package com.wjl.virosa.modules.pins.model.view;

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
 * @time 2023/1/6 14:36
 */
@Data
@Entity
@Immutable
@Table(name = "pin_view")
public class PinView implements Serializable {

  @Id
  private Long id;
  private String content;
  private Instant createTime;
  private Instant updateTime;
  private Long authorId;
  private Long likeNum;

}
