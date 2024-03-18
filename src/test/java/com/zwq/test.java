package com.zwq;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
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

//        PageInfo<Algorithm> pageInfo = algorithmService.getAlgorithmByPage(1);
//        System.out.println(pageInfo.getList().size());



//        Page<Object> page = PageHelper.startPage(1, 5);
//        List<Post> posts = postService.selectAllPost();
//        System.out.println(posts.size());
//        //获取分页相关信息
//        PageInfo<Post> pageInfo = new PageInfo<>(posts, 5);
//        System.out.println(pageInfo.getPageSize());
//        System.out.println(pageInfo.getPageNum());
//
//
//        List<Post> pageInfoPosts = pageInfo.getList();
//        System.out.println(pageInfoPosts.size());
//        for (Post post : pageInfoPosts) {
//            System.out.println("post:" + post.getPost_name());
//        }
//        User user = new User("1","666");
//        int i = userServiceImpl.updateUser(user);
//        System.out.println(i);
//        int i = postService.reduceZan(11);
//        System.out.println(i);
//        Post post = new Post("标题2","内容2",2);
//        postService.addZan(15);
//        int id = postService.getUserIdByPostId(11);
//        System.out.println(id);
//        int i = userServiceImpl.updateUserAll(new User(6, "1323965112", "1323965112", "imgName"));
//        System.out.println(i);

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

