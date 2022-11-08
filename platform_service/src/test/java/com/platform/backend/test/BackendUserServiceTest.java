package com.platform.backend.test;

import com.platform.backend.entity.BackendUser;
import com.platform.backend.service.BackendUserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;

/**
 * Copyright (C), 2017-2022, RainGrd
 * Author: lenovo
 * Date: 2022/10/30 18:48
 * FileName: BackendUserMapperTest
 * Description:
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"classpath:applicationContext-dao.xml","classpath:applicationContext-service.xml"})
public class BackendUserServiceTest {
    @Resource
    private BackendUserService backendUserService;

    @Test
    public void testGet() {
        BackendUser backendUser = backendUserService.login("系统管理员","123456");
        System.out.println("backendUser = " + backendUser);
    }
}
