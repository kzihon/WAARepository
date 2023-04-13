package miu.edu.WAA_labs.service;

import miu.edu.WAA_labs.dtos.PostDto;
import miu.edu.WAA_labs.entity.Comment;
import miu.edu.WAA_labs.entity.Post;
import miu.edu.WAA_labs.entity.User;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

public interface UserService {
    List<User> findAll();
    User findById(Long id);
    User save(User user);
    User update(long id, User user);
    void delete(long id);
    List<PostDto> findPostsForUser(long id);
    List<User> userWithMoreThankOnePost();
    List<User> findUserWithPosts(int num);
    Comment getUserForAParticularPostAndParticularCommnent(long user_id,long post_id,long comment_id);
}
