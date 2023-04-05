package miu.edu.WAA_labs.controller;

import miu.edu.WAA_labs.dtos.PostDto;
import miu.edu.WAA_labs.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/posts")
public class PostController {
    @Autowired
    private PostService postService;

    @ResponseStatus(HttpStatus.OK)
    @GetMapping
    public ResponseEntity<PostsDto> getAll(){
        PostsDto posts = new PostsDto();
        posts.setPostsDtos(postService.findAll());
        return  ResponseEntity.ok(posts);
    }
    @ResponseStatus(HttpStatus.OK)
    @GetMapping("/{id}")
    public ResponseEntity<PostDto> getById(@PathVariable long id) {
        var post = postService.findById(id);
        return ResponseEntity.ok(post);
    }

    @PostMapping
    public ResponseEntity<?> save(@RequestBody PostDto postDto){
        postService.save(postDto);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> update(@PathVariable("id") long id, @RequestBody PostDto postDto){
        postService.update(id, postDto);
        return new ResponseEntity<>(HttpStatus.OK);

    }
    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable("id") long id){
        postService.delete(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }


}
