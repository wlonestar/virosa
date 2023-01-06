package com.wjl.virosa.modules.comments.service.impl;

import com.wjl.virosa.modules.comments.model.entity.PostComment;
import com.wjl.virosa.modules.comments.model.view.PostCommentView;
import com.wjl.virosa.modules.comments.repository.PostCommentRepository;
import com.wjl.virosa.modules.comments.repository.PostCommentViewRepository;
import com.wjl.virosa.modules.comments.service.PostCommentService;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author <a href="mailto:wlonestar@163.com">wjl</a>
 * @version 0.0.1
 * @time 2023/1/6 13:29
 */
@Service
public class PostCommentServiceImpl implements PostCommentService {

  @Resource
  private PostCommentRepository postCommentRepository;

  @Resource
  private PostCommentViewRepository postCommentViewRepository;

  @Override
  public List<PostCommentView> selectAll() {
    return postCommentViewRepository.findAll();
  }

  @Override
  public void add(PostComment postComment) {
    postCommentRepository.save(postComment);
  }

}
