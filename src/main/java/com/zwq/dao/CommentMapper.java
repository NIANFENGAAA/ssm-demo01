package com.zwq.dao;

import com.zwq.pojo.Comment;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface CommentMapper {
    //根据帖子id找到该帖子的所有评论
    List<Comment> getAllCommentByPostId(int id);
    //添加评论
    int addComment(Comment comment);
    //根据帖子id删除所有评论
    int deleteCommentByPostId(int postId);
}
