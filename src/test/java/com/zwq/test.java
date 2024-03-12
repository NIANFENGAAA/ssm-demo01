package com.zwq;

import com.zwq.pojo.Algorithm;
import com.zwq.pojo.Post;
import com.zwq.pojo.User;
import com.zwq.service.AlgorithmService;
import com.zwq.service.PostService;
import com.zwq.service.UserService;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.applet.AppletContext;
import java.security.Timestamp;
import java.util.Date;
import java.util.List;

public class test {
    @Test
    public void testmyproject(){
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        UserService userServiceImpl = (UserService) context.getBean("UserServiceImpl");
        AlgorithmService algorithmService = (AlgorithmService) context.getBean("AlgorithmServiceImpl");
        PostService postService = (PostService) context.getBean("PostServiceImpl");


//        Post post = new Post("标题2","内容2",2);
        postService.addZan(15);

//        List<Post> posts = postService.selectAllPost();
//        System.out.println("全部个数："+posts.size());

//        List<Post> posts = postService.selectPostById(2);
//        for (Post p : posts) {
//            System.out.println("id:"+p.getId());
//        }

//        int i = postService.deletePost(2);
//        System.out.println("删除的行数："+i);

//        int i = postService.addPost(post);
//        System.out.println(i);

//        List<Algorithm> algorithmList = algorithmService.selectAlgorithmByName("唯");
//        System.out.println("集合数量为："+algorithmList.size());

////        Algorithm algorithm = new Algorithm(1,"测试数据","测试数据",1);
//        Algorithm algorithm2 = new Algorithm(2,"测试数据2","测试数据2",1);
//
////        int i = algorithmService.addAlgorithm(algorithm);
//        int i2 = algorithmService.addAlgorithm(algorithm2);
//
////        System.out.println(i);
//        System.out.println(i2);
//
//        List<Algorithm> algorithmList = algorithmService.selectAlgorithmById(2);
//        System.out.println(algorithmList.size());
//        int i = algorithmService.deleteAlgorithmById(2);
//        System.out.println(i);

    }
}

