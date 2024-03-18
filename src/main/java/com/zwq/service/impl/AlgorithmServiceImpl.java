package com.zwq.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.zwq.dao.AlgorithmMapper;
import com.zwq.pojo.Algorithm;
import com.zwq.pojo.Post;
import com.zwq.service.AlgorithmService;

import java.util.List;

public class AlgorithmServiceImpl implements AlgorithmService {
    private AlgorithmMapper algorithmMapper;

    public void setAlgorithmMapper(AlgorithmMapper algorithmMapper) {
        this.algorithmMapper = algorithmMapper;
    }

    @Override
    public int addAlgorithm(Algorithm algorithm) {
        return algorithmMapper.addAlgorithm(algorithm);
    }

    @Override
    public List<Algorithm> selectAlgorithmById(int id) {
        return algorithmMapper.selectAlgorithmById(id);
    }

    @Override
    public Algorithm selectOneAlgorithmById(int id) {
        return algorithmMapper.selectOneAlgorithmById(id);
    }

    @Override
    public List<Algorithm> selectAllAlgorithm() {
        return algorithmMapper.selectAllAlgorithm();
    }

    @Override
    public int deleteAlgorithmById(int id) {
        return algorithmMapper.deleteAlgorithmById(id);
    }

    @Override
    public List<Algorithm> selectAlgorithmByName(String keyword,int userId) {
        return algorithmMapper.selectAlgorithmByName(keyword,userId);
    }

    @Override
    public List<Algorithm> selectAlgorithmByNameAdmin(String keyword) {
        return algorithmMapper.selectAlgorithmByNameAdmin(keyword);
    }

    //分页
    public PageInfo<Algorithm> getAlgorithmByPage(Integer pageNum,String keyword) {
        //开启分页
        Page<Object> page = PageHelper.startPage(pageNum, 3);
        List<Algorithm> algorithmList = algorithmMapper.selectAlgorithmByNameAdmin(keyword);
        //获取分页相关信息
        PageInfo<Algorithm> pageInfo = new PageInfo<>(algorithmList, 3);
        return pageInfo;
    }
}
