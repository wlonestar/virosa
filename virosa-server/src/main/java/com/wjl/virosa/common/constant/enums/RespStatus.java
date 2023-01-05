package com.wjl.virosa.common.constant.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * @author <a href="mailto:wlonestar@163.com">wjl</a>
 * @version 0.0.1
 * @time 2023/1/4 22:54
 */
@Getter
@AllArgsConstructor
public enum RespStatus {

  OK(200, "ok"),

  // TODO: need to add

  ERROR(500, "server error"),
  ;

  private final int status;
  private final String message;

}
