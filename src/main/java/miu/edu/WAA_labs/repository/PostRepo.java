package miu.edu.WAA_labs.repository;


import miu.edu.WAA_labs.entity.Post;

import java.util.List;

public interface PostRepo {
     List<Post> findAll();
     Post findById(Long id);
     void save(Post post);
     void update(long id, Post post);
     void delete(long id);


}
