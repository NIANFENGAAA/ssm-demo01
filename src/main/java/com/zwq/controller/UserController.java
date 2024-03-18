package com.zwq.controller;

import com.github.pagehelper.PageInfo;
import com.zwq.pojo.Post;
import com.zwq.pojo.User;
import com.zwq.service.UserService;
import org.apache.ibatis.annotations.Param;
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
//@RequestMapping("/user")
public class UserController {
    @Autowired
    @Qualifier("UserServiceImpl")
    private UserService userService;


    @RequestMapping("goUpdateUser")
    public String goUpdateUser(){
        return "updateUser";
    }


    @RequestMapping("goUpdatePassword")
    public String goUpdatePassword(){
        return "updatePassword";
    }

    @RequestMapping("updatePassword")
    public String updatePassword(HttpSession session,
                                 @Param(value = "newPassword") String newPassword,
                                 @Param(value = "newPassword2") String newPassword2){

        if (newPassword.equals(newPassword2)){
            String username = (String) session.getAttribute("username");
            User user = new User(username,newPassword);
            int i = userService.updateUser(user);
            System.out.println("修改成功！");
            String success = "修改成功！";
            session.setAttribute("success",success);
            return "updatePassword";
        }else {
            System.out.println("两次密码不同，请重试！");
            String err = "两次密码不同，请重试！";
            session.setAttribute("err",err);
            return "updatePassword";
        }

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

        int presentUserId = (int) session.getAttribute("presentUserId");

        System.out.println("presentUserId:"+ presentUserId);

        User user = new User(presentUserId,emailName,numberName,fileName);

        int i = userService.updateUserAll(user);

        System.out.println(i);

        return "updateUser";
    }

    @RequestMapping("exitUser")
    public String exitUser(HttpSession session){
        session.removeAttribute("username");
        session.removeAttribute("presentUserId");
        return "newLogin";
    }

    @RequestMapping("goAdmin_user")
    public String goAdmin_user(){
        return "admin_user";
    }

    @RequestMapping("adminGetAllUser")
    public String adminGetAllUser(HttpSession session,@RequestParam(value = "keyword") String keyword){
        System.out.println("keyword:"+keyword);
        if (keyword == null){
            keyword = "%%";
        }else {
            keyword = "%" + keyword + "%";
        }
        System.out.println("keyword:"+keyword);
        session.setAttribute("userKeyword",keyword);

        List<User> users = userService.adminSelectAllUser(keyword);
        System.out.println("获取的用户的数量：" + users.size());

        session.setAttribute("users",users);

        return "redirect:adminUserPageInfo?pageNum=1";
    }


    //分页操作
    @RequestMapping("adminUserPageInfo")
    public String adminUserPageInfo(int pageNum, Model model,HttpSession session){
        System.out.println("pageNum:" + pageNum);
        String userKeyword = (String) session.getAttribute("userKeyword");
        System.out.println("userKeyword:" + userKeyword);

        PageInfo<User> page = userService.getUserByPage(pageNum,userKeyword);
        model.addAttribute("userPage",page);
//        //存页数，方便定位
//        session.getServletContext().setAttribute("pageNum",pageNum);
        return "adminHome";
    }

    //禁用用户
    @RequestMapping("prohibitUser")
    public String prohibitUser(int userId){
        int i = userService.prohibitByUserId(userId,1);
        if (i != 0){
            System.out.println("禁用成功！");
            return "redirect:adminGetAllUser?keyword=";
        }else {
            System.out.println("禁用失败！");
            return "redirect:adminGetAllUser?keyword=";
        }
    }

    //启用用户
    @RequestMapping("usingUser")
    public String usingUser(int userId){
        int i = userService.prohibitByUserId(userId,0);
        if (i != 0){
            System.out.println("启用成功！");
            return "redirect:adminGetAllUser?keyword=";
        }else {
            System.out.println("启用失败！");
            return "redirect:adminGetAllUser?keyword=";
        }
    }


    //删除用户
    @RequestMapping("deleteUser")
    public String deleteUser(int userId){
        int i = userService.deleteUser(userId);
        if (i != 0){
            System.out.println("删除成功！");
            return "redirect:adminGetAllUser?keyword=";
        }else {
            System.out.println("删除失败！");
            return "redirect:adminGetAllUser?keyword=";
        }
    }
}
