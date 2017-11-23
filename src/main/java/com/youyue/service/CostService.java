package com.youyue.service;

import com.youyue.domain.Cost;

import java.util.List;

/**
 * Created by dllo on 17/11/22.
 */
public interface CostService {

    List<Cost> findAll();

    void openBuyId(String costId);

    Cost selectByPrimaryKey(Integer costId);

    int updateByPrimaryKeySelective(Cost record);

    int deleteByPrimaryKey(Integer costId);

    int insertSelective(Cost record);

}

