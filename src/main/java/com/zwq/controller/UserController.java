package com.zwq.controller;

import com.zwq.pojo.User;
import com.zwq.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.File;
import java.util.List;
import java.util.UUID;

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

    @RequestMapping("goUpdateUser")
    public String goUpdateUser(){
        return "updateUser";
    }

    @RequestMapping("updateUserData")
    public String updateUserData(MultipartFile img,
                             @RequestParam (value = "emailName")String emailName,
                             @RequestParam (value = "numberName")String numberName,
                             HttpServletRequest request){

        HttpSession session=request.getSession();

//        String path = session.getServletContext().getRealPath("/upload");

        String path = "D:\\IDEA_UI_CODE\\Project\\Project06\\src\\main\\webapp\\img";
        System.out.println("物理路径：" + path);

        String fileName = img.getOriginalFilename();
//        fileName = UUID.randomUUID() + fileName;

        String suffix = fileName.substring(fileName.lastIndexOf("."));
        System.out.println("上传的文件类型为：" + suffix);

        long size = img.getSize();
        System.out.println("头像大小为："+size);

        if (size > 500000 * 1024) {
            session.setAttribute("error1", "文件过大");
            System.out.println("111");
            return "updateUser";
        } else if (suffix.equalsIgnoreCase(".png") || suffix.equalsIgnoreCase(".jpg")) {
            File file = new File(new File(path), fileName);
            //不存在创建
            if (!file.exists()) {
                file.mkdirs();
            }
            try {
                //把文件写入磁盘
                img.transferTo(file);
            } catch (Exception e) {
                e.printStackTrace();
                session.setAttribute("error2", "文件上传失败!");
                System.out.println("222");
                return "updateUser";
            }

        } else {
            session.setAttribute("error3", "不支持上传该类型文件！");
            System.out.println("333");
            return "updateUser";
        }

        System.out.println("头像的名称为：" + fileName);

        int presentId = (int) session.getAttribute("presentId");

        User user = new User(presentId,emailName,numberName,fileName);

        int i = userService.updateUserAll(user);

        System.out.println(i);

        return "userHome";
    }
}
