package com.zwq.service.impl;

import com.zwq.dao.AlgorithmMapper;
import com.zwq.pojo.Algorithm;
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
    public List<Algorithm> selectAlgorithmByName(String keyword) {
        return algorithmMapper.selectAlgorithmByName(keyword);
    }
}
