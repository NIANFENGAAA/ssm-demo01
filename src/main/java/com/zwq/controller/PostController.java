package com.zwq.controller;

import com.github.pagehelper.PageInfo;
import com.zwq.pojo.Algorithm;
import com.zwq.pojo.Post;
import com.zwq.service.CommentService;
import com.zwq.service.PostService;
import com.zwq.service.StarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
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
    @Autowired
    @Qualifier("StarServiceImpl")
    private StarService starService;
    @Autowired
    @Qualifier("CommentServiceImpl")
    private CommentService commentService;

    @RequestMapping("goAddPost")
    public String goAddPost(){
        return "addPost";
    }

    @RequestMapping("goUserHome")
    public String goUserHome(){
        return "userHome";
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

    @RequestMapping("goMyPost")
    public String goMyPost(){
        return "myPost";
    }

    //分页操作
    @RequestMapping("selectAllPostOfUser")
    public String selectAllPostOfUser(int pageNum, Model model,HttpSession session){
        System.out.println("pageNum:" + pageNum);
        int presentUserId = (int) session.getAttribute("presentUserId");
        PageInfo<Post> page = postService.getPostByPage(pageNum,presentUserId);
        model.addAttribute("page",page);
        //存页数，方便定位
        session.getServletContext().setAttribute("pageNum",pageNum);
        return "myPost";
    }


    @RequestMapping("deletePostByUserId")
    public String deletePostByUserId(int id,HttpSession session){
        System.out.println("传过来的id为：" + id);
        int presentUserId = (int) session.getAttribute("presentUserId");
        //删除该帖子的所有评论
        int deleteCommentByPostId = commentService.deleteCommentByPostId(id);
        System.out.println("删除评论数：" + deleteCommentByPostId);

        //删除所有Star的关系
        int deleteRelate = starService.deleteRelate( id);
        System.out.println("删除的star的关系数为：" + deleteRelate);

        int i = postService.deletePost(id);
        System.out.println("删除的行数为：" + i);

        return "userHome";
    }

    @RequestMapping("goForum")
    public String goForum(){
        return "newForum";
    }

    @RequestMapping("getAllPost")
    public String getAllPost(HttpServletRequest request){
        List<Post> posts = postService.selectAllPost();
        System.out.println("所有帖子个数：" + posts.size());

        HttpSession session = request.getSession();
        session.setAttribute("posts",posts);
        int presentUserId = (int) session.getAttribute("presentUserId");
        System.out.println("用户id："+ presentUserId);

        return "newForum";
    }

    @RequestMapping("addZan")
    public String addZan(int postId,HttpSession session){
        int presentUserId = (int) session.getAttribute("presentUserId");
        System.out.println("==============================================================");
        System.out.println("用户id：" + presentUserId);
        System.out.println("postId:" + postId);

        //判断该关系是否已经存在
        int b = starService.selectRelate(presentUserId,postId);
        System.out.println(b);
        if (b != 0){
            //存在，直接进行点赞的判断操作
            //获取当前点赞状态
            System.out.println("111");
            int status = starService.getStatus(presentUserId, postId);
            System.out.println("status:" + status);
            System.out.println("----------------------");
            if (status == 0){
                //该用户还没点赞
                postService.addZan(postId);
                starService.updateStatusTrue(presentUserId,postId);
            }else if (status == 1){
                //该用户已经点赞
                postService.reduceZan(postId);
                starService.updateStatusFalse(presentUserId,postId);
            }
        }
        else {
            //不存在，增加该关系
            System.out.println("222");
            starService.addRelateOfZan(presentUserId, postId);
            //获取当前点赞状态
            int status = starService.getStatus(presentUserId, postId);
            System.out.println("status:" + status);
            System.out.println("----------------------");
            if (status == 0){
                //该用户还没点赞
                postService.addZan(postId);
                starService.updateStatusTrue(presentUserId,postId);
            }else if (status == 1){
                //该用户已经点赞
                postService.reduceZan(postId);
                starService.updateStatusFalse(presentUserId,postId);
            }
        }

        return "redirect:getAllElement";
    }

    @RequestMapping("addZan2")
    public String addZan2(int postId,HttpSession session){
        int presentUserId = (int) session.getAttribute("presentUserId");
        System.out.println("==============================================================");
        System.out.println("用户id：" + presentUserId);
        System.out.println("postId:" + postId);

        //判断该关系是否已经存在
        int b = starService.selectRelate(presentUserId,postId);
        System.out.println(b);
        if (b != 0){
            //存在，直接进行点赞的判断操作
            //获取当前点赞状态
            System.out.println("111");
            int status = starService.getStatus(presentUserId, postId);
            System.out.println("status:" + status);
            System.out.println("----------------------");
            if (status == 0){
                //该用户还没点赞
                postService.addZan(postId);
                starService.updateStatusTrue(presentUserId,postId);
            }else if (status == 1){
                //该用户已经点赞
                postService.reduceZan(postId);
                starService.updateStatusFalse(presentUserId,postId);
            }
        }
        else {
            //不存在，增加该关系
            System.out.println("222");
            starService.addRelateOfZan(presentUserId, postId);
            //获取当前点赞状态
            int status = starService.getStatus(presentUserId, postId);
            System.out.println("status:" + status);
            System.out.println("----------------------");
            if (status == 0){
                //该用户还没点赞
                postService.addZan(postId);
                starService.updateStatusTrue(presentUserId,postId);
            }else if (status == 1){
                //该用户已经点赞
                postService.reduceZan(postId);
                starService.updateStatusFalse(presentUserId,postId);
            }
        }

        return "redirect:getAllElement2";
    }



    @RequestMapping("adminGetAllPost")
    public String adminGetAllPost(HttpSession session,@RequestParam(value = "keyword") String keyword){
        System.out.println("keyword:"+keyword);
        if (keyword == null){
            keyword = "%%";
        }else {
            keyword = "%" + keyword + "%";
        }
        System.out.println("keyword:"+keyword);
        session.setAttribute("PostKeyword",keyword);

        List<Post> posts_admin = postService.selectAllPostByKey(keyword);
        session.setAttribute("posts_admin",posts_admin);


        return "redirect:adminPostPageInfo?pageNum=1";
    }


    //分页操作
    @RequestMapping("adminPostPageInfo")
    public String adminUserPageInfo(int pageNum, Model model, HttpSession session){
        System.out.println("pageNum:" + pageNum);
        String PostKeyword = (String) session.getAttribute("PostKeyword");
        System.out.println("AlgorithmKeyword:" + PostKeyword);

        PageInfo<Post> postByPageAdmin = postService.getPostByPageAdmin(pageNum, PostKeyword);
        model.addAttribute("postByPageAdmin",postByPageAdmin);
//        //存页数，方便定位
//        session.getServletContext().setAttribute("pageNum",pageNum);
        return "admin_post";
    }

    //删除算法
    @RequestMapping("deletePostById")
    public String deleteAlgorithmByUserId(int id,HttpSession session){
        int presentUserId = (int) session.getAttribute("presentUserId");
        //删除该帖子的所有评论
        int deleteCommentByPostId = commentService.deleteCommentByPostId(id);
        System.out.println("删除评论数：" + deleteCommentByPostId);

        //删除所有Star的关系
        int deleteRelate = starService.deleteRelate(id);
        System.out.println("删除的star的关系数为：" + deleteRelate);

        int i = postService.deletePost(id);
        if (i > 0){
            System.out.println("删除成功！");
            return "redirect:adminGetAllPost?keyword=";
        }else {
            System.out.println("删除失败！");
            return "redirect:adminGetAllPost?keyword=";
        }
    }


}
