package com.wjl.virosa.modules.pins.service.impl;

import com.wjl.virosa.modules.pins.model.entity.Pin;
import com.wjl.virosa.modules.pins.repository.PinRepository;
import com.wjl.virosa.modules.pins.service.PinService;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author <a href="mailto:wlonestar@163.com">wjl</a>
 * @version 0.0.1
 * @time 2023/1/5 22:57
 */
@Service
public class PinServiceImpl implements PinService {

  @Resource
  private PinRepository pinRepository;

  @Override
  public List<Pin> selectAll() {
    return pinRepository.findAll();
  }

}
