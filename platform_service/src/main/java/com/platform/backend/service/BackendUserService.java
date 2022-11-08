package com.platform.backend.service;

import com.platform.backend.entity.BackendUser;

/**
 * Copyright (C), 2017-2022, RainGrd
 * Author: lenovo
 * Date: 2022/10/29 11:22
 * FileName: BackendUserService
 * Description: 管理员用户对象
 */

public interface BackendUserService {

    /**
     * 登录方法
     * @param userName 用户名
     * @param password 密码
     * @return com.beyondPlatform.backend.entity.BackendUser
     */
    BackendUser login(String userCode, String password);

}
