package miu.edu.WAA_labs.repository;


import miu.edu.WAA_labs.entity.Post;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PostRepo extends JpaRepository<Post, Long> {

    List<Post> findPostsByTitle(String title);


}
