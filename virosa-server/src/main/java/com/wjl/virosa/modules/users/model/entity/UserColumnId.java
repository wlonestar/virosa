package com.wjl.virosa.modules.users.model.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.Data;

import java.io.Serializable;

/**
 * @author <a href="mailto:wlonestar@163.com">wjl</a>
 * @version 0.0.1
 * @time 2023/1/5 22:29
 */
@Data
@Embeddable
public class UserColumnId implements Serializable {

  @Column(name = "user_id")
  private Long userId;

  @Column(name = "column_id")
  private Long columnId;

  @Column(name = "type")
  private Short type;

}
