package com.platform.developer.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.platform.developer.entity.DevUser;
import com.platform.developer.service.DevUserService;
import com.platform.developer.mapper.DevUserMapper;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @author lenovo
 * @description 针对表【t_dev_user】的数据库操作Service实现
 * @createDate 2022-11-06 19:24:53
 */
@Service
public class DevUserServiceImpl implements DevUserService {
    @Resource
    private DevUserMapper devUserMapper;


    @Override
    public DevUser devLogin(String devCode, String devPassword) {
        return devUserMapper.login(devCode, devPassword);
    }
}




