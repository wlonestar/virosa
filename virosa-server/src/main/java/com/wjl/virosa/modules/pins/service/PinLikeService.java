package com.wjl.virosa.modules.pins.service;

import com.wjl.virosa.modules.pins.model.entity.PinLike;

import java.util.List;

/**
 * @author <a href="mailto:wlonestar@163.com">wjl</a>
 * @version 0.0.1
 * @time 2023/1/8 12:27
 */
public interface PinLikeService {

  List<PinLike> selectAllByUserId(Long userId);

  PinLike selectByPinIdAndUserId(Long pinId, Long userId);

  boolean add(PinLike pinLike);

  boolean update(PinLike pinLike);

}
