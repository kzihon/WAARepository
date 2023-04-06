package miu.edu.WAA_labs.controller;

import miu.edu.WAA_labs.entity.User;
import miu.edu.WAA_labs.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/users")
public class UserController {
    @Autowired
    private UserService userService;

    @GetMapping("/{id}")
    public ResponseEntity<User> getUser(@PathVariable("id") long id){
        return new ResponseEntity<>(userService.findById(id), HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<Users> getAllUsers(){
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
        System.out.println(userService.save(user));
        return new ResponseEntity<>(userService.save(user), HttpStatus.CREATED);
    }
    @GetMapping("/{id}/posts")
    public ResponseEntity<PostsDto> postsForUser(@PathVariable("id") long id){
       PostsDto postsDto = new PostsDto();
       postsDto.setPostsDtos(userService.findPostsForUser(id));
        return new ResponseEntity<>(postsDto, HttpStatus.OK);
    }

}
