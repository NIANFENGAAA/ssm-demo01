package com.zwq.controller;

import com.zwq.pojo.Post;
import com.zwq.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.File;
import java.util.List;
import java.util.UUID;

@Controller
public class PostController {
    @Autowired
    @Qualifier("PostServiceImpl")
    private PostService postService;

    @RequestMapping("goAddPost")
    public String goAddPost(){
        return "addPost";
    }

    @RequestMapping("addPost")
    public String addPost(@RequestParam (value = "name") String name,
                        @RequestParam (value = "content")String content,
                        MultipartFile img,
                        HttpServletRequest request){
        HttpSession session = request.getSession();
        int presentUserId = (int) session.getAttribute("presentUserId");

        System.out.println("name:"+ name);
        System.out.println("content:"+ content);


//
        String path = "D:\\IDEA_UI_CODE\\Project\\Project06\\src\\main\\webapp\\img";
        System.out.println("物理路径：" + path);

        String fileName = img.getOriginalFilename();
//        fileName = UUID.randomUUID() + fileName;

        System.out.println("图片名称："+fileName);

        String suffix = fileName.substring(fileName.lastIndexOf("."));
        System.out.println("上传的文件类型为：" + suffix);

        long size = img.getSize();
        System.out.println("图片字节大小："+size);

        if (size > 500000 * 1024) {
            session.setAttribute("error1", "文件过大");
            System.out.println("111");
            return "addPost";
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
                return "addPost";
            }

        } else {
            session.setAttribute("error3", "不支持上传该类型文件！");
            System.out.println("333");
            return "addPost";
        }

        Post post = new Post(name,content,presentUserId,0,fileName);
        int i = postService.addPost(post);
        System.out.println("添加的行数:" + i);

        return "addPost";

    }
    @RequestMapping("selectPostByUserId")
    public String selectPostByUserId(HttpServletRequest request){
        HttpSession session = request.getSession();
        int presentUserId = (int) session.getAttribute("presentUserId");
        List<Post> posts = postService.selectPostById(presentUserId);
        System.out.println("取得集合长度："+ posts.size());
        session.setAttribute("posts",posts);
        return "myPost";
    }

    @RequestMapping("deletePostByUserId")
    public String deletePostByUserId(int id){
        System.out.println("传过来的id为：" + id);

        int i = postService.deletePost(id);
        System.out.println("删除的行数为：" + i);

        return "myPost";
    }

    @RequestMapping("goForum")
    public String goForum(){
        return "forum";
    }

    @RequestMapping("getAllPost")
    public String getAllPost(HttpServletRequest request){
        List<Post> posts = postService.selectAllPost();
        System.out.println("所有帖子个数：" + posts.size());

        HttpSession session = request.getSession();
        session.setAttribute("posts",posts);
        int presentUserId = (int) session.getAttribute("presentUserId");
        System.out.println("用户id："+ presentUserId);

        return "forum";
    }

    @RequestMapping("addZan")
    public String addZan(int postId){
        System.out.println("postId:"+postId);
        int i = postService.addZan(postId);
        System.out.println("改变的行数：" + i);
        return "redirect:getAllPost";
    }
}
