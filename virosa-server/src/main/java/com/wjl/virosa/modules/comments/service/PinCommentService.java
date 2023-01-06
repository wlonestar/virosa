package com.wjl.virosa.modules.comments.service;

import com.wjl.virosa.modules.comments.model.entity.PinComment;
import com.wjl.virosa.modules.comments.model.view.PinCommentView;

import java.util.List;

/**
 * @author <a href="mailto:wlonestar@163.com">wjl</a>
 * @version 0.0.1
 * @time 2023/1/5 22:50
 */
public interface PinCommentService {

  List<PinCommentView> selectAll();

  void add(PinComment pinComment);

}
