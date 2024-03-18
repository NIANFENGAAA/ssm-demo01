package com.zwq.dao;

import com.zwq.pojo.Post;

import java.util.List;

public interface PostMapper {
    //查找全部帖子
    List<Post> selectAllPost();
    //添加帖子
    int addPost(Post post);
    //根据当前用户id查找帖子
    List<Post> selectPostById(int userid);
    //根据帖子id删除帖子
    int deletePost(int id);
    //根据帖子id点一个赞
    int addZan(int postId);
    //根据帖子的id拿到user的id
    int getUserIdByPostId(int postId);
    //根据帖子id减少一个赞
    int reduceZan(int postId);
    //根据帖子id拿到该帖子
    Post getPostByPostId(int postId);
    //根据关键词查找所有帖子
    List<Post> selectAllPostByKey(String keyword);
}
