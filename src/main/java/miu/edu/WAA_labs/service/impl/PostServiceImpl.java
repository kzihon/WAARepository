package miu.edu.WAA_labs.service.impl;

import miu.edu.WAA_labs.dtos.PostDto;
import miu.edu.WAA_labs.entity.Post;
import miu.edu.WAA_labs.repository.PostRepo;
import miu.edu.WAA_labs.service.PostService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class PostServiceImpl implements PostService {
    @Autowired
    ModelMapper modelMapper;
    @Autowired
    private PostRepo postRepo;

    @Override
    public List<PostDto> findAll() {
        List<Post> posts = postRepo.findAll();

        return posts.stream().map(post ->
            modelMapper.map(post, PostDto.class)
        ).collect(Collectors.toList());
    }

    @Override
    public PostDto findById(Long id) {
        return modelMapper.map(postRepo.findById(id), PostDto.class);
    }

    @Override
    public void save(PostDto postDto) {
        postRepo.save(modelMapper.map(postDto, Post.class));
    }

    @Override
    public void update(long id, PostDto postDto) {
        postRepo.update(id, modelMapper.map(postDto, Post.class));
    }

    @Override
    public void delete(long id) {
        postRepo.delete(id);
    }
}
