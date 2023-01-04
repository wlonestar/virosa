package com.wjl.virosa.controller;

import com.wjl.virosa.annotation.TimeLog;
import com.wjl.virosa.constant.consts.RespResult;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author <a href="mailto:wlonestar@163.com">wjl</a>
 * @version 0.0.1
 * @time 2023/1/4 23:25
 */
@Slf4j
@TimeLog
@RestController
@RequestMapping(path = "/test")
public class HelloController {

  @RequestMapping(method = RequestMethod.GET, path = "/hello")
  public RespResult<?> hello() {
    return RespResult.success("Hello");
  }

}
