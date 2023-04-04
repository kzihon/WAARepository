package miu.edu.WAA_labs.service.impl;

import miu.edu.WAA_labs.dtos.PostDto;
import miu.edu.WAA_labs.entity.Post;
import miu.edu.WAA_labs.repository.PostRepo;
import miu.edu.WAA_labs.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class PostServiceImpl implements PostService {
    @Autowired
    private PostRepo postRepo;

    @Override
    public List<PostDto> findAll() {
        return null;
    }

    @Override
    public Post findById(Long id) {
        return null;
    }

    @Override
    public void save(Post post) {

    }

    @Override
    public void update(long id, PostDto postDto) {

    }

    @Override
    public void delete(long id) {

    }
}
