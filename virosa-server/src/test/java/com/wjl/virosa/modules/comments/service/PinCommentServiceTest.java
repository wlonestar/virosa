package com.wjl.virosa.modules.comments.service;

import com.wjl.virosa.modules.comments.model.view.PinCommentView;
import jakarta.annotation.Resource;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@SpringBootTest
@RunWith(SpringRunner.class)
class PinCommentServiceTest {

  @Resource
  PinCommentService pinCommentService;

  @Test
  void selectAll() {
    List<PinCommentView> pinCommentViews = pinCommentService.selectAll();
    for (PinCommentView pinCommentView : pinCommentViews) {
      System.out.println(pinCommentView);
    }
  }

}
