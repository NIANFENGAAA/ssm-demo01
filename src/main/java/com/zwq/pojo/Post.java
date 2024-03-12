package com.zwq.pojo;

public class Post {
    private int id;
    private String post_name;
    private String post_content;
    private int user_id;
    private int zan;
    private String img;

    public Post() {
    }

    public Post(String post_name, String post_content, int user_id, int zan, String img) {
        this.post_name = post_name;
        this.post_content = post_content;
        this.user_id = user_id;
        this.zan = zan;
        this.img = img;
    }

    public int getZan() {
        return zan;
    }

    public void setZan(int zan) {
        this.zan = zan;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public Post(String post_name, String post_content, int user_id) {
        this.post_name = post_name;
        this.post_content = post_content;
        this.user_id = user_id;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getPost_name() {
        return post_name;
    }

    public void setPost_name(String post_name) {
        this.post_name = post_name;
    }

    public String getPost_content() {
        return post_content;
    }

    public void setPost_content(String post_content) {
        this.post_content = post_content;
    }

    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }
}
