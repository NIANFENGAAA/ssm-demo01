package com.zwq.dao;

import com.zwq.pojo.User;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface UserMapper {
    //增加用户
    int addUser(User user);

    //删除用户
    int deleteUser(@Param("UserId") int id);

    //修改密码
    int updateUser(User user);

    //查找一个用户
    User getUser(int id);

    //查找全部用户
    List<User> getAllUser();

    //确认用户登录
    User loginUser(@Param("username") String username);

    //修改用户信息
    int updateUserAll(User user);
    //确认用户身份
    int getFlag(User user);
    //管理员查询所有用户
    List<User> adminSelectAllUser(String keyword);
    //根据用户id启用和禁用用户
    int prohibitByUserId(@Param("userId") int userId,@Param("status") int status);
    //根据id删除用户
    int deleteUserById(int userId);



}
