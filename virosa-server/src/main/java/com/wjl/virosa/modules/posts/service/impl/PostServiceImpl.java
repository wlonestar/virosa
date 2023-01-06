package com.wjl.virosa.modules.posts.service.impl;

import com.wjl.virosa.modules.posts.model.entity.Post;
import com.wjl.virosa.modules.posts.repository.PostRepository;
import com.wjl.virosa.modules.posts.service.PostService;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author <a href="mailto:wlonestar@163.com">wjl</a>
 * @version 0.0.1
 * @time 2023/1/6 13:33
 */
@Service
public class PostServiceImpl implements PostService {

  @Resource
  private PostRepository postRepository;

  @Override
  public List<Post> selectAll() {
    return postRepository.findAll();
  }

}
