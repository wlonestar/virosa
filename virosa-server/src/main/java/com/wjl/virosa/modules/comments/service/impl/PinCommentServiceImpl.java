package com.wjl.virosa.modules.comments.service.impl;

import com.wjl.virosa.modules.comments.model.entity.PinComment;
import com.wjl.virosa.modules.comments.model.view.PinCommentView;
import com.wjl.virosa.modules.comments.repository.PinCommentRepository;
import com.wjl.virosa.modules.comments.repository.PinCommentViewRepository;
import com.wjl.virosa.modules.comments.service.PinCommentService;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author <a href="mailto:wlonestar@163.com">wjl</a>
 * @version 0.0.1
 * @time 2023/1/5 22:50
 */
@Service
public class PinCommentServiceImpl implements PinCommentService {

  @Resource
  private PinCommentRepository pinCommentRepository;

  @Resource
  private PinCommentViewRepository pinCommentViewRepository;

  @Override
  public List<PinCommentView> selectAll() {
    return pinCommentViewRepository.findAll();
  }

  @Override
  public void add(PinComment pinComment) {
    pinCommentRepository.save(pinComment);
  }

}
