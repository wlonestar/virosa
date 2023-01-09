package com.wjl.virosa.modules.pins.service.impl;

import com.wjl.virosa.modules.pins.model.entity.PinLike;
import com.wjl.virosa.modules.pins.model.entity.PinLikeId;
import com.wjl.virosa.modules.pins.repository.PinLikeRepository;
import com.wjl.virosa.modules.pins.service.PinLikeService;
import jakarta.annotation.Resource;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

/**
 * @author <a href="mailto:wlonestar@163.com">wjl</a>
 * @version 0.0.1
 * @time 2023/1/8 12:27
 */
@Service
public class PinLikeServiceImpl implements PinLikeService {

  @Resource
  private PinLikeRepository pinLikeRepository;

  @Override
  public List<PinLike> selectAll() {
    return pinLikeRepository.findAll();
  }

  @Override
  public List<PinLike> selectAllByUserId(Long userId) {
    return pinLikeRepository.findAllByUserId(userId);
  }

  @Override
  public Page<PinLike> selectAllByPage(Pageable pageable) {
    return pinLikeRepository.findAll(pageable);
  }

  @Override
  public Page<PinLike> selectAllByUserIdAndPage(Long userId, Pageable pageable) {
    return pinLikeRepository.findAllByUserIdAndPage(userId, pageable);
  }

  @Override
  public PinLike selectById(PinLikeId id) {
    return pinLikeRepository.findById(id)
        .orElse(new PinLike(new PinLikeId(id.getPinId(), id.getUserId()), (short) 0));
  }

  @Override
  public boolean add(PinLike pinLike) {
    pinLikeRepository.save(pinLike);
    return true;
  }

  @Override
  public boolean update(PinLike pinLike) {
    PinLike newPinLike = pinLikeRepository.findById(pinLike.getId()).orElse(null);
    if (!Objects.equals(newPinLike, null)) {
      newPinLike.setType(pinLike.getType());
      pinLikeRepository.save(newPinLike);
      return true;
    }
    return false;
  }

  @Override
  public boolean deleteById(PinLikeId id) {
    return false;
  }

}
