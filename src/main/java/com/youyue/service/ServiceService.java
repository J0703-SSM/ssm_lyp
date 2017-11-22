package com.youyue.service;

import com.youyue.domain.Service;

import java.util.List;

/**
 * Created by dllo on 17/11/15.
 */
public interface ServiceService {

    List<Service> findAll(Integer pc);

}
