package com.wjl.virosa.modules.pins.service;

import com.wjl.virosa.modules.pins.model.entity.Pin;
import com.wjl.virosa.modules.pins.model.view.PinView;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

/**
 * @author <a href="mailto:wlonestar@163.com">wjl</a>
 * @version 0.0.1
 * @time 2023/1/5 22:57
 */
public interface PinService {

  List<PinView> selectAll();

  List<PinView> selectAllByAuthorId(Long authorId);

  Page<PinView> selectAllByPage(Pageable pageable);

  Page<PinView> selectAllByAuthorIdAndPage(Long authorId, Pageable pageable);

  PinView selectById(Long id);

  boolean add(Pin pin);

  boolean update(Pin pin);

  boolean deleteById(Long id);

}
