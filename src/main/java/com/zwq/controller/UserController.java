package com.zwq.controller;

import com.zwq.pojo.User;
import com.zwq.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/user")
public class UserController {
    @Autowired
    @Qualifier("UserServiceImpl")
    private UserService userService;

    @RequestMapping("/allUser")
    public String getAllUser(Model model){
        List<User> allUser = userService.getAllUser();
        model.addAttribute("allUser",allUser);
        return "allUser";
    }
}
