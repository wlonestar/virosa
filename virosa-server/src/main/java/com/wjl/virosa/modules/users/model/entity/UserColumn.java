package com.wjl.virosa.modules.users.model.entity;

import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Data;

import java.io.Serializable;

/**
 * @author <a href="mailto:wlonestar@163.com">wjl</a>
 * @version 0.0.1
 * @time 2023/1/5 22:29
 */
@Data
@Entity
@Table(name = "user_Column")
public class UserColumn implements Serializable {

  @EmbeddedId
  private UserColumnId id;

}
