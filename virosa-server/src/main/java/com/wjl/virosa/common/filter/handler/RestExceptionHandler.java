package com.wjl.virosa.common.filter.handler;

import com.wjl.virosa.common.constant.consts.RespResult;
import com.wjl.virosa.common.constant.enums.RespStatus;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.mapping.PropertyReferenceException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.time.format.DateTimeParseException;

/**
 * @author <a href="mailto:wlonestar@163.com">wjl</a>
 * @version 0.0.1
 * @time 2023/1/4 23:03
 */
@Slf4j
@RestControllerAdvice
public class RestExceptionHandler {

//  @ExceptionHandler(Exception.class)
//  @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
//  public RespResult<String> exception(Exception e) {
//    log.error("global error => {}", e.getMessage(), e);
//    return RespResult.fail(RespStatus.ERROR.getStatus(), e.getMessage());
//  }

  // TODO: need to add more


  @ExceptionHandler(DateTimeParseException.class)
  @ResponseStatus(HttpStatus.BAD_REQUEST)
  public RespResult<String> dateTimeParseException(Exception e) {
    log.error("datetime parse error => {}", e.getMessage(), e);
    return RespResult.fail(RespStatus.PARSE_ERROR.getStatus(), e.getMessage());
  }

  // TODO: need to rename
  @ExceptionHandler(PropertyReferenceException.class)
  @ResponseStatus(HttpStatus.BAD_REQUEST)
  public RespResult<String> propertyReferenceException(Exception e) {
    log.error("param error => {}", e.getMessage(), e);
    return RespResult.fail(RespStatus.PARAM_ERROR.getStatus(), e.getMessage());
  }

}
