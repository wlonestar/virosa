package com.wjl.virosa.modules.pins.service;

import com.wjl.virosa.modules.pins.model.entity.Pin;

import java.util.List;

/**
 * @author <a href="mailto:wlonestar@163.com">wjl</a>
 * @version 0.0.1
 * @time 2023/1/5 22:57
 */
public interface PinService {

  List<Pin> selectAll();

}
