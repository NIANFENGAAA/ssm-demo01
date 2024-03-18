package com.zwq.service;

import com.github.pagehelper.PageInfo;
import com.zwq.pojo.Post;

import java.util.List;

public interface PostService {
    //添加帖子
    int addPost(Post post);
    //查找全部帖子
    List<Post> selectAllPost();
    //根据关键词查找所有帖子
    List<Post> selectAllPostByKey(String keyword);
    //根据当前用户id查找帖子
    List<Post> selectPostById(int userid);
    //根据帖子id删除帖子
    int deletePost(int id);
    //根据帖子id点一个赞
    int addZan(int postId);
    //根据帖子id减少一个赞
    int reduceZan(int postId);
    //根据帖子的id拿到user的id
    int getUserIdByPostId(int postId);
    //根据帖子id拿到该帖子
    Post getPostByPostId(int postId);
    //分页
    PageInfo<Post> getPostByPage(Integer pageNum,int userId);
    PageInfo<Post> getPostByPageAdmin(Integer pageNum, String keyword);
}
