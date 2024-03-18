package com.zwq.controller;

import com.mysql.cj.Session;
import com.zwq.pojo.Comment;
import com.zwq.service.CommentService;
import com.zwq.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;

@Controller
public class CommentController {
    @Autowired
    @Qualifier("CommentServiceImpl")
    private CommentService commentService;


    @RequestMapping("addComment")
    public String addComment(@RequestParam (value = "postId") int postId, @RequestParam (value = "commentName") String commentName,
                             HttpSession session){
        System.out.println("==============================");
        System.out.println("postId:" + postId);
        System.out.println("commentName:" + commentName);

        int presentUserId = (int) session.getAttribute("presentUserId");
        Comment comment = new Comment();
        comment.setComment_user_id(presentUserId);
        comment.setComment_post_id(postId);
        comment.setComment_content(commentName);
        commentService.addComment(comment);

        return "newForum";
    }
}
