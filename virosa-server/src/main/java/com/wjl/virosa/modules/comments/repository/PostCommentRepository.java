package com.wjl.virosa.modules.comments.repository;

import com.wjl.virosa.modules.comments.model.entity.PostComment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @author <a href="mailto:wlonestar@163.com">wjl</a>
 * @version 0.0.1
 * @time 2023/1/6 13:29
 */
@Repository
public interface PostCommentRepository extends JpaRepository<PostComment, Long> {
}
