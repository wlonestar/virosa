package com.wjl.virosa.modules.comments.repository;

import com.wjl.virosa.common.repository.ReadOnlyRepository;
import com.wjl.virosa.modules.comments.model.view.PostCommentView;
import org.springframework.stereotype.Repository;

/**
 * @author <a href="mailto:wlonestar@163.com">wjl</a>
 * @version 0.0.1
 * @time 2023/1/6 15:09
 */
@Repository
public interface PostCommentViewRepository extends ReadOnlyRepository<PostCommentView, Long> {
}
