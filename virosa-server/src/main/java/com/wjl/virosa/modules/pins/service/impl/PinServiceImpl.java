package com.wjl.virosa.modules.pins.service.impl;

import com.wjl.virosa.modules.pins.model.view.PinView;
import com.wjl.virosa.modules.pins.repository.PinRepository;
import com.wjl.virosa.modules.pins.repository.PinViewRepository;
import com.wjl.virosa.modules.pins.service.PinService;
import jakarta.annotation.Resource;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

/**
 * @author <a href="mailto:wlonestar@163.com">wjl</a>
 * @version 0.0.1
 * @time 2023/1/5 22:57
 */
@Service
public class PinServiceImpl implements PinService {

  @Resource
  private PinRepository pinRepository;

  @Resource
  private PinViewRepository pinViewRepository;

  @Override
  public List<PinView> selectAll() {
    return pinViewRepository.findAll();
  }

  @Override
  public List<PinView> selectAllByAuthorId(Long authorId) {
    return pinViewRepository.findAllByAuthorId(authorId);
  }

  @Override
  public Page<PinView> selectAllByPage(Pageable pageable) {
    return pinViewRepository.findAll(pageable);
  }

  @Override
  public Page<PinView> selectAllByPageAndAuthorId(Long authorId, Pageable pageable) {
    return pinViewRepository.findAllByAuthorId(authorId, pageable);
  }

  @Override
  public PinView selectById(Long id) {
    Optional<PinView> optional = pinViewRepository.findById(id);
    return optional.orElse(null);
  }

}
