package com.zwq.service;

import com.github.pagehelper.PageInfo;
import com.zwq.pojo.User;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface UserService {
    int addUser(User user);

    //删除用户
    int deleteUser(int id);

    //修改密码
    int updateUser(User user);

    //查找一个用户
    User getUser(int id);

    //查找全部用户
    List<User> getAllUser();

    //确认用户登录
    User loginUser(String username);

    //修改用户信息
    int updateUserAll(User user);
    //确认用户身份
    int getFlag(User user);
    //管理员查询所有用户
    List<User> adminSelectAllUser(String keyword);
    //分页
    PageInfo<User> getUserByPage(Integer pageNum, String keyword);
    //根据用户id禁用用户
    int prohibitByUserId(int userId,int status);
    //根据id删除用户
    int deleteUserById(int userId);
}
