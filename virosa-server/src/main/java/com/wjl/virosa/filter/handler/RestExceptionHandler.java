package com.wjl.virosa.filter.handler;

import com.wjl.virosa.constant.consts.RespResult;
import com.wjl.virosa.constant.enums.RespStatus;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * @author <a href="mailto:wlonestar@163.com">wjl</a>
 * @version 0.0.1
 * @time 2023/1/4 23:03
 */
@Slf4j
@RestControllerAdvice
public class RestExceptionHandler {

  @ExceptionHandler(Exception.class)
  @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
  public RespResult<String> exception(Exception e) {
    log.error("全局异常信息 ex={}", e.getMessage(), e);
    return RespResult.fail(RespStatus.ERROR.getStatus(), e.getMessage());
  }

  // TODO: need to add more

}
