package com.zwq.service;

import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface StarService {
    //根据帖子id找到所有的收藏数量
    int getStarCountByPostId(int postId);
    //查询用户的点赞状态
    int getStatus(int userId, int postId);
    //未点赞，改为点赞状态
    int updateStatusTrue(int userId,int postId);
    //已经点赞，改为未点赞状态
    int updateStatusFalse(int userId,int postId);
    //点赞前先将关系加入该表
    int addRelateOfZan(int userId,int postId);
    //判断该关系是否已经存在
    int selectRelate(@Param("userId")int userId,@Param("postId") int postId);
    //修改收藏状态，显示已收藏
    int updateStatue_Star(@Param("userId")int userId,@Param("postId") int postId);
    //增加该关系时并赋值收藏状态
    int addStatus_Star(@Param("userId")int userId,@Param("postId") int postId);
    //查找用户的收藏状态
    int selectStatus_Star(@Param("userId")int userId,@Param("postId") int postId);
    //修改用户的收藏状态
    int updateStatus_Star(@Param("userId")int userId,@Param("postId") int postId,@Param("status")int status);
    //查询用户收藏的所有帖子id
    List<Integer> getAllStarPostId(int userId);
    //删除联系
    int deleteRelate(@Param("postId") int postId);
}
