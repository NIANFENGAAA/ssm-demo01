package com.zwq.pojo;

import org.springframework.stereotype.Controller;

import java.util.List;

@Controller
public class PostDetailEle {
    private User user;
    private Post post;
    private List<Comment> comments;
    private int star;

    public PostDetailEle() {
    }

    public PostDetailEle(User user, Post post, List<Comment> comments, int star) {
        this.user = user;
        this.post = post;
        this.comments = comments;
        this.star = star;
    }

    public List<Comment> getComments() {
        return comments;
    }

    public void setComments(List<Comment> comments) {
        this.comments = comments;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Post getPost() {
        return post;
    }

    public void setPost(Post post) {
        this.post = post;
    }



    public int getStar() {
        return star;
    }

    public void setStar(int star) {
        this.star = star;
    }
}
