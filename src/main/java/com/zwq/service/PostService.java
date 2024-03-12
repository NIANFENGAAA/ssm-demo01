package com.zwq.service;

import com.zwq.pojo.Post;

import java.util.List;

public interface PostService {
    //添加帖子
    int addPost(Post post);
    //查找全部帖子
    List<Post> selectAllPost();
    //根据当前用户id查找帖子
    List<Post> selectPostById(int userid);
    //根据帖子id删除帖子
    int deletePost(int id);
    //根据帖子id点一个赞
    int addZan(int postId);
}
