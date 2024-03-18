package com.zwq.controller;

import com.zwq.pojo.*;
import com.zwq.service.CommentService;
import com.zwq.service.PostService;
import com.zwq.service.StarService;
import com.zwq.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;

@Controller
public class ForumController {
    @Autowired
    @Qualifier("PostServiceImpl")
    private PostService postService;
    @Autowired
    @Qualifier("UserServiceImpl")
    private UserService userService;
    @Autowired
    @Qualifier("CommentServiceImpl")
    private CommentService commentService;
    @Autowired
    @Qualifier("StarServiceImpl")
    private StarService starService;


    @RequestMapping("goNewForum")
    public String goNewForum(){
        return "newForum";
    }


    @RequestMapping("getAllElement")
    public String getAllElement(HttpServletRequest request){
        HttpSession session = request.getSession();

        //获取全部帖子
        List<Post> posts = postService.selectAllPost();
        List<ForumEle> forumEleList = new ArrayList<>();
        for (Post post : posts) {
            User user = userService.getUser(postService.getUserIdByPostId(post.getId()));
            System.out.println("用户名称：" + user.getUsername());

            List<Comment> allComment = commentService.getAllCommentByPostId(post.getId());

            int starCount = starService.getStarCountByPostId(post.getId());
            System.out.println("starCount:"+starCount);
            ForumEle forumEle = new ForumEle(user,post,allComment.size(),starCount);
            forumEleList.add(forumEle);
        }

        System.out.println("论坛元素的个数："+forumEleList.size());

        session.setAttribute("forumEleList",forumEleList);

        return "newForum";
    }

    //论坛首页
    @RequestMapping("getAllElement0")
    public String getAllElement0(HttpServletRequest request,@RequestParam(value = "keyword") String keyword){
        HttpSession session = request.getSession();
        System.out.println("keyword:"+keyword);
        if (keyword == null){
            keyword = "%%";
        }else {
            keyword = "%" + keyword + "%";
        }
        System.out.println("keyword:"+keyword);

        //获取全部帖子
        List<Post> posts = postService.selectAllPostByKey(keyword);
        List<ForumEle> forumEleList = new ArrayList<>();
        for (Post post : posts) {
            User user = userService.getUser(postService.getUserIdByPostId(post.getId()));
            System.out.println("用户名称：" + user.getUsername());

            List<Comment> allComment = commentService.getAllCommentByPostId(post.getId());

            int starCount = starService.getStarCountByPostId(post.getId());
            System.out.println("starCount:"+starCount);
            ForumEle forumEle = new ForumEle(user,post,allComment.size(),starCount);
            forumEleList.add(forumEle);
        }

        System.out.println("论坛元素的个数："+forumEleList.size());

        session.setAttribute("forumEleList",forumEleList);

        return "newForum";
    }

    @RequestMapping("getAllElement2")
    public String getAllElement2(HttpServletRequest request){
        HttpSession session = request.getSession();

        //获取全部帖子
        List<Post> posts = postService.selectAllPost();
        List<ForumEle> forumEleList = new ArrayList<>();
        for (Post post : posts) {
            User user = userService.getUser(postService.getUserIdByPostId(post.getId()));
            System.out.println("用户名称：" + user.getUsername());

            List<Comment> allComment = commentService.getAllCommentByPostId(post.getId());

            int starCount = starService.getStarCountByPostId(post.getId());
            System.out.println("starCount:"+starCount);
            ForumEle forumEle = new ForumEle(user,post,allComment.size(),starCount);
            forumEleList.add(forumEle);
        }

        System.out.println("论坛元素的个数："+forumEleList.size());

        session.setAttribute("forumEleList",forumEleList);

        return "postDetail";
    }

    @RequestMapping("goPostDetail")
    public String goPostDetail(){
        return "postDetail";
    }

    @RequestMapping("getPostDetail")
    public String getPostDetail(int postId, HttpSession session){
        System.out.println("postId:" + postId);
        Post post = postService.getPostByPostId(postId);

        User user = userService.getUser(postService.getUserIdByPostId(post.getId()));
        System.out.println("用户名称：" + user.getUsername());

        List<Comment> allComment = commentService.getAllCommentByPostId(post.getId());
        for (Comment comment : allComment) {
            User user1 = userService.getUser(comment.getComment_user_id());
            comment.setUser(user1);
            System.out.println("评论中用户名：" + comment.getUser().getUsername());
            Post post1 = postService.getPostByPostId(comment.getComment_post_id());
            comment.setPost(post1);
        }
        int star = starService.getStarCountByPostId(post.getId());
        System.out.println("starCount:"+star);
        System.out.println("allComment长度：" + allComment.size());
        PostDetailEle postDetailEle = new PostDetailEle(user,post,allComment,star);
        session.setAttribute("postDetailEle",postDetailEle);

        return "postDetail";
    }
}
