package com.wjl.virosa.modules.pins.controller;

import com.wjl.virosa.common.annotation.TimeLog;
import com.wjl.virosa.modules.pins.service.PinLikeService;
import jakarta.annotation.Resource;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * pin like controller
 *
 * @author <a href="mailto:wlonestar@163.com">wjl</a>
 * @version 0.0.1
 * @time 2023/1/8 12:40
 */
@Slf4j
@TimeLog
@RestController
@RequestMapping(path = "/pin/like")
public class PinLikeController {

  @Resource
  private PinLikeService pinLikeService;




}
