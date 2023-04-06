package miu.edu.WAA_labs.service;

import miu.edu.WAA_labs.dtos.PostDto;
import miu.edu.WAA_labs.entity.Post;
import miu.edu.WAA_labs.entity.User;

import java.util.List;

public interface UserService {
    List<User> findAll();
    User findById(Long id);
    User save(User user);
    User update(long id, User user);
    void delete(long id);
    List<PostDto> findPostsForUser(long id);
    List<User> userWithMoreThankOnePost();
}
