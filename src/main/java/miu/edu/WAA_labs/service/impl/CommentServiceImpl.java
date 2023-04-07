package miu.edu.WAA_labs.service.impl;

import miu.edu.WAA_labs.entity.Comment;
import miu.edu.WAA_labs.repository.CommentRepo;
import miu.edu.WAA_labs.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CommentServiceImpl implements CommentService {
    @Autowired
    private CommentRepo commentRepo;

    @Override
    public List<Comment> findAll() {
        return commentRepo.findAll();
    }

    @Override
    public Comment findById(Long id) {
        return commentRepo.findById(id).get();
    }

    @Override
    public Comment save(Comment comment) {
        return commentRepo.save(comment);
    }

    @Override
    public Comment update(long id, Comment comment) {
        Comment updatedComment = this.findById(id);
        updatedComment = comment;

        return updatedComment;
    }

    @Override
    public void delete(long id) {
        commentRepo.deleteById(id);
    }
}
