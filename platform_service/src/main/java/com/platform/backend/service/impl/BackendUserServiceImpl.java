package com.platform.backend.service.impl;

import com.platform.backend.entity.BackendUser;
import com.platform.backend.mapper.BackendUserMapper;
import com.platform.backend.service.BackendUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Copyright (C), 2017-2022, RainGrd
 * Author: lenovo
 * Date: 2022/10/29 11:23
 * FileName: BackendUserServiceImpl
 * Description: 用户业务实现层
 */
@Service("backendUserService")
public class BackendUserServiceImpl implements BackendUserService {

    @Autowired
    private BackendUserMapper backendUserMapper;

    @Override
    public BackendUser login(String userCode, String password) {
        return backendUserMapper.backEndUserLogin(userCode, password);
//        return null;
    }
}
