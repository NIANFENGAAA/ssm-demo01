package com.zwq.service;

import com.zwq.pojo.Algorithm;

import java.util.List;

public interface AlgorithmService {
    int addAlgorithm(Algorithm algorithm);

    //根据当前用户id查找该用户上传的算法
    List<Algorithm> selectAlgorithmById(int id);
    //根据当前算法id查找该算法
    Algorithm selectOneAlgorithmById(int id);
    //查询所有算法
    List<Algorithm> selectAllAlgorithm();
    //根据id删除指定算法
    int deleteAlgorithmById(int id);
    //根据算法名称来查找算法
    List<Algorithm> selectAlgorithmByName(String keyword);
}
