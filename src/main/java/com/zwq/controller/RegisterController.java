package com.zwq.controller;

import com.zwq.pojo.User;
import com.zwq.service.UserService;
import com.zwq.utils.CheckCodeUtil;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@Controller
public class RegisterController {

    @Autowired
    @Qualifier("UserServiceImpl")
    private UserService userService;

//    跳转注册页面
    @RequestMapping("goRegisterUser")
    public String goRegisterUser(){
        return "newRegister";
    }

    @RequestMapping("RegisterUser")
    public String register(@RequestParam(value = "username") String username,
                           @RequestParam(value = "password") String password,
                           @RequestParam(value = "password2") String password2,
                           @RequestParam(value = "email") String email,
                           @RequestParam(value = "number") String number,
                           HttpServletResponse response,
                           HttpServletRequest request, Model model){
        HttpSession session=request.getSession();

        System.out.println(password);
        System.out.println(password2);
        System.out.println(email);
        System.out.println(number);

        if (userService.loginUser(username) != null){
            System.out.println("用户名太受欢迎，请换一个！");
            String Register_msg1 = "用户名太受欢迎，请换一个！";
            session.setAttribute("Register_msg1",Register_msg1);
            return "Register";
        } else if (!password.equals(password2)) {
            System.out.println("两次密码格式不一样，请重试！");
            String Register_msg2 = "两次密码格式不一样，请重试！";
            session.setAttribute("Register_msg2",Register_msg2);
            return "Register";
        }else {
            userService.addUser(new User(username,password,email,number));
            System.out.println("注册成功！");
            String Register_msg3 = "注册成功！";
            session.setAttribute("Register_msg3",Register_msg3);
            return "newLogin";
        }
    }

    @RequestMapping("checkCode")
    public void checkCode( HttpServletResponse response, HttpServletRequest request, Model model) throws IOException {
        ServletOutputStream outputStream = response.getOutputStream();
        String checkCode = CheckCodeUtil.outputVerifyImage(100,50,outputStream,4);

        //将验证码存入session中
        HttpSession session = request.getSession();
        session.setAttribute("checkCodeGen",checkCode);

    }

}
