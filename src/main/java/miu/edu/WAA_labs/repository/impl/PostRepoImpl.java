package miu.edu.WAA_labs.repository.impl;

import lombok.*;
import miu.edu.WAA_labs.entity.Post;
import miu.edu.WAA_labs.repository.PostRepo;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;



//@Repository
public class PostRepoImpl {//implements PostRepo {
    private static List<Post> posts;
    private static int postId = 300;
    static {
        posts = new ArrayList<>();
        Post post1 = new Post(1,"Blog1","Environment","Jack");
        Post post2 = new Post(2,"Blog2", "Social", "Bob");
        Post post3 = new Post(3,"Blog3", "Natural", "Kate");

        posts.add(post1);
        posts.add(post2);
        posts.add(post3);
    }


//    @Override
//    public List<Post> findAll() {
//        return posts;
//    }
//
//    @Override
//    public Post findById(Long id) {
//        return posts.stream().filter(x->x.getId()==id).findFirst().orElse(null);
//    }
//
//    @Override
//    public void save(Post post) {
//        post.setId(postId);
//        postId++;
//        posts.add(post);
//    }
//
//    @Override
//    public void update(long id, Post post) {
//        Post toUpdate = findById(id);
//        toUpdate.setTitle(post.getTitle());
//        toUpdate.setAuthor(post.getAuthor());
//        toUpdate.setContent(post.getContent());
//
//        posts.set((int)id, toUpdate);
//
//
//
//    }
//
//    @Override
//    public void delete(long id) {
//        Post post = posts.stream().filter(i->i.getId()==id).findFirst().get();
//        posts.remove(post);
//    }
}
