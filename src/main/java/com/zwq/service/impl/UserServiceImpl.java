package com.zwq.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.zwq.dao.UserMapper;
import com.zwq.pojo.Algorithm;
import com.zwq.pojo.User;
import com.zwq.service.UserService;

import java.util.List;


public class UserServiceImpl implements UserService {
    private UserMapper userMapper;

    public void setUserMapper(UserMapper userMapper) {
        this.userMapper = userMapper;
    }

    @Override
    public int addUser(User user) {
        return userMapper.addUser(user);
    }

    @Override
    public int deleteUser(int id) {
        return userMapper.deleteUser(id);
    }

    @Override
    public int updateUser(User user) {
        return userMapper.updateUser(user);
    }

    @Override
    public User getUser(int id) {
        return userMapper.getUser(id);
    }

    @Override
    public List<User> getAllUser() {
        return userMapper.getAllUser();
    }

    @Override
    public User loginUser(String username) {
        return userMapper.loginUser(username);
    }

    @Override
    public int updateUserAll(User user) {
        return userMapper.updateUserAll(user);
    }

    @Override
    public int getFlag(User user) {
        return userMapper.getFlag(user);
    }

    @Override
    public List<User> adminSelectAllUser(String keyword) {
        return userMapper.adminSelectAllUser(keyword);
    }
    //分页
    public PageInfo<User> getUserByPage(Integer pageNum,String keyword) {
        //开启分页
        Page<Object> page = PageHelper.startPage(pageNum, 5);
        List<User> userList = userMapper.adminSelectAllUser(keyword);
        //获取分页相关信息
        PageInfo<User> pageInfo = new PageInfo<>(userList, 5);
        return pageInfo;
    }

    @Override
    public int prohibitByUserId(int userId,int status) {
        return userMapper.prohibitByUserId(userId,status);
    }

    @Override
    public int deleteUserById(int userId) {
        return userMapper.deleteUserById(userId);
    }
}
