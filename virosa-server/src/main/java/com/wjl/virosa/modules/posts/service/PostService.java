package com.wjl.virosa.modules.posts.service;

import com.wjl.virosa.modules.posts.model.entity.Post;

import java.util.List;

/**
 * @author <a href="mailto:wlonestar@163.com">wjl</a>
 * @version 0.0.1
 * @time 2023/1/6 13:32
 */
public interface PostService {

  List<Post> selectAll();

}
