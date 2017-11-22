package com.youyue.service.impl;

import com.youyue.domain.Admin_info;
import com.youyue.mapper.Admin_infoMapper;
import com.youyue.service.Admin_infoService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * Created by dllo on 17/11/13.
 */
@Service("admin_infoService")
public class Admin_infoServiceImpl implements Admin_infoService {

    @Resource
    private Admin_infoMapper admin_infoMapper;

    public Admin_info login(String username, String password) {

        return admin_infoMapper.login(username, password);
    }

    public void updateById(String password, Integer adminId) {
        admin_infoMapper.updateById(password, adminId);
    }

    public Admin_info selectByPrimaryKey(Integer adminId) {
        return admin_infoMapper.selectByPrimaryKey(adminId);
    }

//    public Admin_info findId() {
//        return admin_infoMapper.findId();
//    }
}
