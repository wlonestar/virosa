package com.wjl.virosa.modules.comments.service;

import com.apifan.common.random.source.NumberSource;
import com.apifan.common.random.source.OtherSource;
import com.wjl.virosa.modules.comments.model.entity.PostComment;
import com.wjl.virosa.modules.posts.model.entity.Post;
import com.wjl.virosa.modules.posts.service.PostService;
import com.wjl.virosa.modules.users.model.entity.User;
import com.wjl.virosa.modules.users.service.UserService;
import jakarta.annotation.Resource;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.time.Instant;
import java.util.ArrayList;
import java.util.List;

@SpringBootTest
@RunWith(SpringRunner.class)
class PostCommentServiceTest {

  @Resource
  PostCommentService postCommentService;

  @Resource
  PostService postService;

  @Resource
  UserService userService;

  @Test
  void add() {
    List<User> users = userService.selectAll();
    List<Long> userIds = new ArrayList<>();
    for (User user : users) {
      userIds.add(user.getId());
    }

    List<Post> posts = postService.selectAll();
    List<Long> postIds = new ArrayList<>();
    for (Post post : posts) {
      postIds.add(post.getId());
    }

//    for (int i = 0; i < 5; i++) {
//      PostComment postComment = new PostComment();
//      postComment.setId(i + 1L);
//      postComment.setContent(OtherSource.getInstance().randomChineseSentence());
//      postComment.setUploadTime(Instant.now());
//      postComment.setAuthorId(NumberSource.getInstance().randomLong(1, userIds.size() + 1));
//      postComment.setPostId(NumberSource.getInstance().randomLong(1, postIds.size()));
//      postComment.setParentId(null);
//      postCommentService.add(postComment);
//    }

    for (int i = 0; i < 15; i++) {
      PostComment postComment = new PostComment();
      postComment.setId(i + 1L);
      postComment.setContent(OtherSource.getInstance().randomChineseSentence());
      postComment.setUploadTime(Instant.now());
      postComment.setAuthorId(NumberSource.getInstance().randomLong(1, userIds.size() + 1));
      postComment.setPostId(NumberSource.getInstance().randomLong(1, postIds.size()));
      postComment.setParentId(NumberSource.getInstance().randomLong(1, 5));
      postCommentService.add(postComment);
    }

  }

}
