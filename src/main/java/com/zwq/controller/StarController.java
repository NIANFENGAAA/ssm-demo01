package com.zwq.controller;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.zwq.pojo.Post;
import com.zwq.service.PostService;
import com.zwq.service.StarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;

@Controller
public class StarController {
    @Autowired
    @Qualifier("StarServiceImpl")
    private StarService starService;
    @Autowired
    @Qualifier("PostServiceImpl")
    private PostService postService;

    @RequestMapping("addStar")
    public String addStar(int postId, HttpSession session){
        int presentUserId = (int) session.getAttribute("presentUserId");
        //判断该关系是否已经存在
        if (starService.selectRelate(presentUserId,postId) != 0){
            if (starService.selectStatus_Star(presentUserId,postId) == 0){
                //存在，直接进行语句修改操作
                starService.updateStatue_Star(presentUserId,postId);
            }else
                starService.updateStatus_Star(presentUserId,postId,0);
            return "redirect:getAllElement";
        }else {
            //不存在，增加该关系时并赋值
            starService.addRelateOfZan(presentUserId, postId);
            starService.updateStatue_Star(presentUserId,postId);
            return "redirect:getAllElement";
        }
    }

    @RequestMapping("addStar2")
    public String addStar2(int postId, HttpSession session){
        int presentUserId = (int) session.getAttribute("presentUserId");
        //判断该关系是否已经存在
        if (starService.selectRelate(presentUserId,postId) != 0){
            if (starService.selectStatus_Star(presentUserId,postId) == 0){
                //存在，直接进行语句修改操作
                starService.updateStatue_Star(presentUserId,postId);
            }else
                starService.updateStatus_Star(presentUserId,postId,0);
            return "redirect:getAllElement2";
        }else {
            //不存在，增加该关系时并赋值
            starService.addRelateOfZan(presentUserId, postId);
            starService.updateStatue_Star(presentUserId,postId);
            return "redirect:getAllElement2";
        }
    }

    @RequestMapping("getAllStar")
    public String getAllStar(Model model, HttpSession session){
        int presentUserId = (int) session.getAttribute("presentUserId");
        List<Integer> postIds = starService.getAllStarPostId(presentUserId);
        List<Post> posts = new ArrayList<>();

        for (Integer postId : postIds) {
            posts.add(postService.getPostByPostId(postId));
        }

        System.out.println("=================");
        System.out.println(posts.size());
        System.out.println("=================");
        session.setAttribute("allStarPost",posts);
        return "allStarPost";
    }

    @RequestMapping("deleteStarPost")
    public String deleteStarPost(int postId, HttpSession session){
        int presentUserId = (int) session.getAttribute("presentUserId");
        starService.updateStatus_Star(presentUserId,postId,0);
        return "redirect:getAllStar";
    }

}
