package com.zwq;

import com.zwq.pojo.Comment;
import com.zwq.service.CommentService;
import com.zwq.service.PostService;
import com.zwq.service.StarService;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

public class TestFourm {
    @Test
    public void test(){
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        CommentService commentService = (com.zwq.service.CommentService) context.getBean("CommentServiceImpl");
        StarService starServiceImpl = (StarService) context.getBean("StarServiceImpl");

        List<Integer> allStarPostId = starServiceImpl.getAllStarPostId(2);
        for (Integer i : allStarPostId) {
            System.out.println(i);
        }
//        List<Comment> allCommentByPostId = commentService.getAllCommentByPostId(12);
//        System.out.println(allCommentByPostId.size());
//        int i = starServiceImpl.getStarCountByPostId(11);
//        System.out.println(i);
//        Integer status = starServiceImpl.getStatus(1, 11);
//        System.out.println(status);
//        int i = starServiceImpl.updateStatusTrue(1, 11);
//        System.out.println(i);
//        starServiceImpl.updateStatusFalse(1,11);
//        boolean b = starServiceImpl.selectRelate(2, 11);
//        System.out.println(b);
//        Comment comment = new Comment(2,12,"太帅啦！！！！！");
//        int i = commentService.addComment(comment);
//        System.out.println(i);

    }
}
