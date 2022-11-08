package com.platform.developer.service;

import com.platform.developer.entity.DevUser;

/**
* @author lenovo
* @description 针对表【t_dev_user】的数据库操作Service
* @createDate 2022-11-06 19:24:53
*/
public interface DevUserService  {

    DevUser devLogin(String devCode, String devPassword);
}
