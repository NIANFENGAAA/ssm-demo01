package com.zwq.service;

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
}
