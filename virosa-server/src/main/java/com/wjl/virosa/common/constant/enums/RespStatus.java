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

  OK(20, "ok"),

  // TODO: need to add
  NOT_EXIST(31, "object does not exist"),

  OBJECT_NULL(32, "the object is null"),


  ERROR(50, "server error"),
  PARSE_ERROR(51, "parse error"),
  PARAM_ERROR(52, "param error");

  private final int status;
  private final String message;

}
