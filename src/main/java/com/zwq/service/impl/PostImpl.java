package com.zwq.service.impl;

import com.zwq.dao.PostMapper;
import com.zwq.pojo.Post;
import com.zwq.service.PostService;

import java.util.List;

public class PostImpl implements PostService {
    private PostMapper postMapper;

    public void setPostMapper(PostMapper postMapper) {
        this.postMapper = postMapper;
    }

    @Override
    public int addPost(Post post) {
        return postMapper.addPost(post);
    }

    @Override
    public List<Post> selectAllPost() {
        return postMapper.selectAllPost();
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
}
