package com.zwq.pojo;

public class User {
    private int id;
    private String username;
    private String password;
    private String email;
    private String number;
    private String img;

    public User() {
    }

    public User(int id, String email, String number, String img) {
        this.id = id;
        this.email = email;
        this.number = number;
        this.img = img;
    }

    public User(String username, String password, String email, String number, String img) {
        this.username = username;
        this.password = password;
        this.email = email;
        this.number = number;
        this.img = img;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public User(String username, String password, String email, String number) {
        this.username = username;
        this.password = password;
        this.email = email;
        this.number = number;
    }

    public User(String username, String password) {
        this.username = username;
        this.password = password;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                '}';
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
