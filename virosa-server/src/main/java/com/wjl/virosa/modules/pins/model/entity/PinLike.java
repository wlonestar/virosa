package com.wjl.virosa.modules.pins.model.entity;

import jakarta.persistence.Column;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Data;

import java.io.Serializable;

/**
 * @author <a href="mailto:wlonestar@163.com">wjl</a>
 * @version 0.0.1
 * @time 2023/1/5 20:26
 */
@Data
@Entity
@Table(name = "pin_like")
public class PinLike implements Serializable {

  @EmbeddedId
  private PinLikeId id;

  @Column(name = "type")
  private Short type;

}
