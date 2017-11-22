package com.youyue.mapper;

import com.youyue.domain.Role_info;

public interface Role_infoMapper {
    int deleteByPrimaryKey(Integer roleId);

    int insert(Role_info record);

    int insertSelective(Role_info record);

    Role_info selectByPrimaryKey(Integer roleId);

    int updateByPrimaryKeySelective(Role_info record);

    int updateByPrimaryKey(Role_info record);
}