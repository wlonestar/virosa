package com.wjl.virosa.modules.pins.service.impl;

import com.wjl.virosa.modules.pins.model.entity.PinLike;
import com.wjl.virosa.modules.pins.model.entity.PinLikeId;
import com.wjl.virosa.modules.pins.repository.PinLikeRepository;
import com.wjl.virosa.modules.pins.service.PinLikeService;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

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
  public List<PinLike> selectAllByUserId(Long userId) {
    List<PinLike> pinLikes = pinLikeRepository.findAll();
    return pinLikes.stream()
        .filter(pinLike -> pinLike.getId().getUserId().equals(userId))
        .collect(Collectors.toList());
  }

  @Override
  public PinLike selectByPinIdAndUserId(Long pinId, Long userId) {
    return pinLikeRepository.findById(new PinLikeId(pinId, userId))
        .orElse(new PinLike(new PinLikeId(pinId, userId), (short) 0));
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

}
