package com.zwq.pojo;

public class ForumEle {
    private User user;
    private Post post;
    private int commentNumber;
    private int star;


    public ForumEle() {
    }

    public ForumEle(User user, Post post, int commentNumber) {
        this.user = user;
        this.post = post;
        this.commentNumber = commentNumber;
    }

    public ForumEle(User user, Post post, int commentNumber, int star) {
        this.user = user;
        this.post = post;
        this.commentNumber = commentNumber;
        this.star = star;
    }

    public int getStar() {
        return star;
    }

    public void setStar(int star) {
        this.star = star;
    }

    public int getCommentNumber() {
        return commentNumber;
    }

    public void setCommentNumber(int commentNumber) {
        this.commentNumber = commentNumber;
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


}
