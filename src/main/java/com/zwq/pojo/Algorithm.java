package com.zwq.pojo;

public class Algorithm {
    private int id;
    private String algorithm_name;
    private String way;
    private int user_id;

    public Algorithm(int id, String algorithm_name, String way, int user_id) {
        this.id = id;
        this.algorithm_name = algorithm_name;
        this.way = way;
        this.user_id = user_id;
    }

    public Algorithm() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getAlgorithm_name() {
        return algorithm_name;
    }

    public void setAlgorithm_name(String algorithm_name) {
        this.algorithm_name = algorithm_name;
    }

    public String getWay() {
        return way;
    }

    public void setWay(String way) {
        this.way = way;
    }

    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }
}
