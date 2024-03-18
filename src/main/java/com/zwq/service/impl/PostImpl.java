package com.zwq.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.zwq.dao.PostMapper;
import com.zwq.pojo.Algorithm;
import com.zwq.pojo.Post;
import com.zwq.service.PostService;

import java.util.List;

public class PostImpl implements PostService {
    private PostMapper postMapper;

    @Override
    public List<Post> selectAllPost() {
        return postMapper.selectAllPost();
    }

    @Override
    public List<Post> selectAllPostByKey(String keyword) {
        return postMapper.selectAllPostByKey(keyword);
    }

    public void setPostMapper(PostMapper postMapper) {
        this.postMapper = postMapper;
    }

    @Override
    public int addPost(Post post) {
        return postMapper.addPost(post);
    }

    @Override
    public List<Post> selectPostById(int userid) {
        return postMapper.selectPostById(userid);
    }

    @Override
    public int deletePost(int id) {
        return postMapper.deletePost(id);
    }

    @Override
    public int addZan(int postId) {
        return postMapper.addZan(postId);
    }

    @Override
    public int reduceZan(int postId) {
        return postMapper.reduceZan(postId);
    }

    @Override
    public int getUserIdByPostId(int postId) {
        return postMapper.getUserIdByPostId(postId);
    }

    @Override
    public Post getPostByPostId(int postId) {
        return postMapper.getPostByPostId(postId);
    }

    //分页
    public PageInfo<Post> getPostByPage(Integer pageNum,int userId) {
        //开启分页
        Page<Object> page = PageHelper.startPage(pageNum, 5);
        List<Post> posts = selectPostById(userId);
        //获取分页相关信息
        PageInfo<Post> pageInfo = new PageInfo<>(posts, 5);
        return pageInfo;
    }

    //分页
    public PageInfo<Post> getPostByPageAdmin(Integer pageNum, String keyword) {
        //开启分页
        Page<Object> page = PageHelper.startPage(pageNum, 5);
        List<Post> posts = postMapper.selectAllPostByKey(keyword);
        //获取分页相关信息
        PageInfo<Post> pageInfo = new PageInfo<>(posts, 5);
        return pageInfo;
    }

}
