package com.youyue.service.impl;

import com.youyue.domain.Cost;
import com.youyue.mapper.CostMapper;
import com.youyue.service.CostService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by dllo on 17/11/22.
 */
@Service("costService")
public class CostServiceImpl implements CostService {

    @Resource
    private CostMapper costMapper;

    public List<Cost> findAll() {
        return costMapper.findAll();
    }

    public void openBuyId(String costId) {
        costMapper.openBuyId("开通", "on", costId);
    }

    public Cost selectByPrimaryKey(Integer costId) {
        return costMapper.selectByPrimaryKey(costId);
    }

    public int updateByPrimaryKeySelective(Cost record) {
        return costMapper.updateByPrimaryKeySelective(record);
    }

    public int deleteByPrimaryKey(Integer costId) {
        return costMapper.deleteByPrimaryKey(costId);
    }


}
