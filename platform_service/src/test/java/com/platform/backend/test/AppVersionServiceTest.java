package com.platform.backend.test;

import com.platform.backend.entity.AppVersion;
import com.platform.backend.service.AppVersionService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;
import java.math.BigDecimal;

/**
 * Copyright (C), 2017-2022, RainGrd
 * Author: lenovo
 * Date: 2022/11/1 19:36
 * FileName: AppVersionServiceTest
 * Description:
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:applicationContext-dao.xml", "classpath:applicationContext-service.xml"})
public class AppVersionServiceTest {


    @Resource
    private AppVersionService appVersionService;

    @Test
    public void queryAppVersionByVersionIdTest() {
        System.out.println(appVersionService.queryAppVersionByVersionId(33L));
    }

    @Test
    public void updateAppVersionByAppIdTest() {
/*        AppVersion appVersion = new AppVersion();
        appVersion.setAppId(52L);
        appVersion.setVersionInfo("V1.1.1简介");
        BigDecimal bigDecimal = new BigDecimal("3");
            appVersion.setVersionSize(bigDecimal);
        appVersionService.updateAppVersionByAppId(appVersion);*/
    }
}
