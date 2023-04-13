package miu.edu.WAA_labs.controller;

import miu.edu.WAA_labs.aop.ExecutionTime;
import miu.edu.WAA_labs.entity.Comment;
import miu.edu.WAA_labs.entity.MyException;
import miu.edu.WAA_labs.entity.Post;
import miu.edu.WAA_labs.entity.User;
import miu.edu.WAA_labs.repository.UserRepo;
import miu.edu.WAA_labs.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {
    @Autowired
    private UserService userService;
    @Autowired
    private UserRepo userRepo;
    @ExecutionTime
    @GetMapping("/{id}")
    public ResponseEntity<User> getUser(@PathVariable("id") long id){
        return new ResponseEntity<>(userService.findById(id), HttpStatus.OK);
    }

    @GetMapping("{user_id}/posts/{post_id}/comments/{comment_id}")
    public ResponseEntity<Comment> getUserForAParticularPostAndParticularCommnent(
            @PathVariable("user_id") long user_id,
            @PathVariable("post_id") long post_id,
            @PathVariable("comment_id") long comment_id
    ){
        return new ResponseEntity<>(userService.getUserForAParticularPostAndParticularCommnent(user_id,post_id,comment_id), HttpStatus.OK);
    }


    @GetMapping
    public ResponseEntity<Users> getAllUsers() {//throws Exception{
      //  throw new MyException("myexception");
        Users users = new Users();
        users.setUsers(userService.findAll());
        return new ResponseEntity<>(users, HttpStatus.OK);
    }
    @GetMapping("/posts")
    public ResponseEntity<Users> userWithMoreThankOnePost(){
        Users users = new Users();
        users.setUsers(userService.userWithMoreThankOnePost());
        return new ResponseEntity<>(users, HttpStatus.OK);
    }


    @PostMapping
    public ResponseEntity<User> createUser(@RequestBody User user){
        System.out.println(user);
        User user1 = userService.save(user);
        return new ResponseEntity<>(user1, HttpStatus.CREATED);
    }
//    @GetMapping("/{id}/posts")
//    public ResponseEntity<PostsDto> postsForUser(@PathVariable("id") long id){
//       PostsDto postsDto = new PostsDto();
//       postsDto.setPostsDtos(userService.findPostsForUser(id));
//        return new ResponseEntity<>(postsDto, HttpStatus.OK);
//    }
    @GetMapping("/{id}/posts")
    public List<Post> postsForUser(@PathVariable("id") long id){

        return userRepo.findPostsForUserId(id);
    }
    @GetMapping("/filters/posts/{num}")
    public List<User> findUserWithPosts(@PathVariable int num) {
        return userRepo.findUserWithPosts(num);

    }

}
