package miu.edu.WAA_labs.service;

import miu.edu.WAA_labs.dtos.PostDto;
import miu.edu.WAA_labs.entity.Post;

import java.util.List;

public interface PostService {
    List<PostDto> findAll();
    PostDto findById(Long id);
    void save(PostDto post);
    void update(long id, PostDto postDto);
    void delete(long id);
}
