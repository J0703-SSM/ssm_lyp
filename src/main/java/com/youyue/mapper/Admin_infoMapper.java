package com.youyue.mapper;

import com.youyue.domain.Admin_info;
import org.apache.ibatis.annotations.Param;

public interface Admin_infoMapper {
    int deleteByPrimaryKey(Integer adminId);

    int insert(Admin_info record);

    int insertSelective(Admin_info record);

    Admin_info selectByPrimaryKey(Integer adminId);

    int updateByPrimaryKeySelective(Admin_info record);

    int updateByPrimaryKey(Admin_info record);

    Admin_info login(@Param("username") String username,
                     @Param("password") String password);

    void updateById(@Param("password") String password,
                    @Param("adminId") Integer adminId);


//    Admin_info findId();

}