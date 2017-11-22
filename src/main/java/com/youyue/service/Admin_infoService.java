package com.youyue.service;

import com.youyue.domain.Admin_info;

/**
 * Created by dllo on 17/11/13.
 */
public interface Admin_infoService {

    Admin_info login(String username, String password);

    void updateById(String password, Integer adminId);

    Admin_info selectByPrimaryKey(Integer adminId);

//    Admin_info findId();

}
