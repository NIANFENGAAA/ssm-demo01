package com.zwq.controller;

import com.zwq.pojo.User;
import com.zwq.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@Controller
public class LoginController {
    @Autowired
    @Qualifier("UserServiceImpl")
    private UserService userService;

    @RequestMapping("goLoginUser")
    public String goLoginUser(){
        return "login";
    }


    @RequestMapping("/loginUser")
    public String login(@RequestParam(value = "username")String username, @RequestParam(value = "password") String password, HttpServletResponse response, HttpServletRequest request, Model model){
        HttpSession session=request.getSession();

        User user = userService.loginUser( username);

        if (user == null){
            System.out.println("账号不存在，请先注册！");
            String msg1 = "账号不存在，请先注册！";
            session.setAttribute("usernameError",msg1);
            return "Register";
        }else if (user.getPassword().equals(password)){
            System.out.println("登陆成功！");
            session.setAttribute("presentUserId",user.getId());
            System.out.println("presentUserId:" + user.getId());
            session.setAttribute("username", username);//登录成功则在session对象中添加用户名信息
            return "userHome";
        }else {
            System.out.println("密码错误，请重试！");
            String msg2 = "密码错误，请重试！";
            session.setAttribute("passwordError",msg2);
            return "login";
        }

    }
}
