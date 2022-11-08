package com.platform.backend.test;

import com.platform.backend.entity.BackendUser;
import com.platform.backend.mapper.BackendUserMapper;
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
@ContextConfiguration(locations={"classpath:applicationContext-dao.xml"})
public class BackendUserMapperTest {
    @Resource
    private BackendUserMapper backendUserMapper;

    @Test
    public void testGet() {
        BackendUser backendUser = backendUserMapper.selectByPrimaryKey(1L);
        System.out.println("backendUser = " + backendUser);
    }
}
