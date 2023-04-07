package miu.edu.WAA_labs.service;

import miu.edu.WAA_labs.dtos.PostDto;
import miu.edu.WAA_labs.entity.Comment;

import java.util.List;

public interface CommentService {
    List<Comment> findAll();
    Comment findById(Long id);
    Comment save(Comment comment);
    Comment update(long id, Comment comment);
    void delete(long id);
}
