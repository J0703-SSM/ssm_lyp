package com.youyue.mapper;

import com.youyue.domain.Module_info;

public interface Module_infoMapper {
    int deleteByPrimaryKey(Integer moduleId);

    int insert(Module_info record);

    int insertSelective(Module_info record);

    Module_info selectByPrimaryKey(Integer moduleId);

    int updateByPrimaryKeySelective(Module_info record);

    int updateByPrimaryKey(Module_info record);
}