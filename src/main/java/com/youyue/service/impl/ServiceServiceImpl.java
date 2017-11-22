package com.youyue.service.impl;

import com.youyue.domain.Service;
import com.youyue.mapper.ServiceMapper;
import com.youyue.service.ServiceService;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by dllo on 17/11/15.
 */
@org.springframework.stereotype.Service("serviceService")
public class ServiceServiceImpl implements ServiceService {

    @Resource
    private ServiceMapper serviceMapper;

    public List<Service> findAll(Integer pc) {
        return serviceMapper.findAll(pc);
    }
}
