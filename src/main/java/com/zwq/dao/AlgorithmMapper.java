package com.zwq.dao;

import com.zwq.pojo.Algorithm;
import com.zwq.pojo.User;
import org.apache.ibatis.annotations.Param;

import java.util.ArrayList;
import java.util.List;

public interface AlgorithmMapper {
    //增加算法
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
    List<Algorithm> selectAlgorithmByName(@Param("keyword") String keyword, @Param("userId") int userId);
    List<Algorithm> selectAlgorithmByNameAdmin(String keyword);

}
