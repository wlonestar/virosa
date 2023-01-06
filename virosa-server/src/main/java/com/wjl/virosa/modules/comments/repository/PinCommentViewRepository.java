package com.wjl.virosa.modules.comments.repository;

import com.wjl.virosa.common.repository.ReadOnlyRepository;
import com.wjl.virosa.modules.comments.model.view.PinCommentView;
import org.springframework.stereotype.Repository;

/**
 * @author <a href="mailto:wlonestar@163.com">wjl</a>
 * @version 0.0.1
 * @time 2023/1/6 14:26
 */
@Repository
public interface PinCommentViewRepository extends ReadOnlyRepository<PinCommentView, Long> {
}
