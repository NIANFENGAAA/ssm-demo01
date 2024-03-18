package com.zwq.service.impl;

import com.zwq.dao.StarMapper;
import com.zwq.service.StarService;

import java.util.List;

public class StarServiceImpl implements StarService {
    private StarMapper starMapper;

    public void setStarMapper(StarMapper starMapper) {
        this.starMapper = starMapper;
    }

    @Override
    public int getStarCountByPostId(int postId) {
        return starMapper.getStarCountByPostId(postId);
    }

    @Override
    public int getStatus(int userId, int postId) {
        return starMapper.getStatus(userId,postId);
    }

    @Override
    public int updateStatusTrue(int userId, int postId) {
        return starMapper.updateStatusTrue(userId,postId);
    }

    @Override
    public int updateStatusFalse(int userId, int postId) {
        return starMapper.updateStatusFalse(userId,postId);
    }

    @Override
    public int addRelateOfZan(int userId, int postId) {
        return starMapper.addRelateOfZan(userId,postId);
    }

    @Override
    public int selectRelate(int userId, int postId) {
        return starMapper.selectRelate(userId,postId);
    }

    @Override
    public int updateStatue_Star(int userId, int postId) {
        return starMapper.updateStatue_Star(userId,postId);
    }

    @Override
    public int addStatus_Star(int userId, int postId) {
        return starMapper.addStatus_Star(userId,postId);
    }

    @Override
    public int selectStatus_Star(int userId, int postId) {
        return starMapper.selectStatus_Star(userId,postId);
    }

    @Override
    public int updateStatus_Star(int userId, int postId, int status) {
        return starMapper.updateStatus_Star(userId,postId,status);
    }

    @Override
    public List<Integer> getAllStarPostId(int userId) {
        return starMapper.getAllStarPostId(userId);
    }

    @Override
    public int deleteRelate( int postId) {
        return starMapper.deleteRelate(postId);
    }
}
