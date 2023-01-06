package com.wjl.virosa.modules.comments.service;

import com.wjl.virosa.modules.comments.model.entity.PostComment;
import com.wjl.virosa.modules.comments.model.view.PostCommentView;

import java.util.List;

/**
 * @author <a href="mailto:wlonestar@163.com">wjl</a>
 * @version 0.0.1
 * @time 2023/1/6 13:29
 */
public interface PostCommentService {

  List<PostCommentView> selectAll();

  void add(PostComment postComment);

}
