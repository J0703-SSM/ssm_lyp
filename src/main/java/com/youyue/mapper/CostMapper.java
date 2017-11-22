package com.youyue.mapper;

import com.youyue.domain.Cost;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface CostMapper {
    int deleteByPrimaryKey(@Param("costId") Integer costId);

    int insert(Cost record);

    int insertSelective(Cost record);

    Cost selectByPrimaryKey(Integer costId);

    int updateByPrimaryKeySelective(Cost record);

    int updateByPrimaryKey(Cost record);

    List<Cost> findAll();

    void openBuyId(@Param("status") String status,
                   @Param("costType") String costType,
                   @Param("costId") String costId);

}