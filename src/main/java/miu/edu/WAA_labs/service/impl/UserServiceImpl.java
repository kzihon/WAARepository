package miu.edu.WAA_labs.service.impl;

import miu.edu.WAA_labs.dtos.PostDto;
import miu.edu.WAA_labs.entity.Comment;
import miu.edu.WAA_labs.entity.Post;
import miu.edu.WAA_labs.entity.User;
import miu.edu.WAA_labs.repository.PostRepo;
import miu.edu.WAA_labs.repository.UserRepo;
import miu.edu.WAA_labs.service.UserService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    ModelMapper modelMapper;
    @Autowired
    private UserRepo userRepo;

    @Override
    public List<User> findAll() {
        return userRepo.findAll();
    }

    @Override
    public User findById(Long id) {
        return userRepo.findById(id).get();
    }

    @Override
    public User save(User user) {
          return userRepo.save(user);
    }

    @Override
    public User update(long id, User user) {
        User updatedUser = userRepo.findById(id).get();
        updatedUser= user;
        user.setId(id);
        return userRepo.save(user);
    }

    @Override
    public void delete(long id) {
        userRepo.deleteById(id);
    }

    @Override
    public List<PostDto> findPostsForUser(long id) {
        User user= userRepo.findById(id).get();
        return user.getPosts().stream().map(l->modelMapper.map(l, PostDto.class)).collect(Collectors.toList());
    }
    public List<User> userWithMoreThankOnePost(){
        return userRepo.userWithMoreThankOnePost();
    }

    @Override
    public Comment getUserForAParticularPostAndParticularCommnent(long user_id, long post_id, long comment_id) {
//        User user = userRepo.findById(user_id).get();
//        Post post=user.getPosts().stream().filter(p->p.getId()==post_id).findFirst().get();
//        Comment comment=post.getComments().stream().filter(comment1 -> comment1.getId()==comment_id).findFirst().get();



        return userRepo.getUserForAParticularPostAndParticularCommnent(user_id, post_id, comment_id);
    }
}
