package com.zwq.service.impl;

import com.zwq.dao.CommentMapper;
import com.zwq.pojo.Comment;
import com.zwq.service.CommentService;

import java.util.List;

public class CommentServiceImpl implements CommentService {
    private CommentMapper commentMapper;

    public void setCommentMapper(CommentMapper commentMapper) {
        this.commentMapper = commentMapper;
    }

    @Override
    public List<Comment> getAllCommentByPostId(int id) {
        return commentMapper.getAllCommentByPostId(id);
    }

    @Override
    public int addComment(Comment comment) {
        return commentMapper.addComment(comment);
    }

    @Override
    public int deleteCommentByPostId(int postId) {
        return commentMapper.deleteCommentByPostId(postId);
    }
}
