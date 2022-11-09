package com.platform.backend.test;

import com.github.pagehelper.PageInfo;
import com.platform.backend.entity.AppInfo;
import com.platform.backend.service.AppInfoService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Copyright (C), 2017-2022, RainGrd
 * Author: lenovo
 * Date: 2022/10/31 13:03
 * FileName: AppInfoServiceTest
 * Description:
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:applicationContext-dao.xml", "classpath:applicationContext-service.xml"})
public class AppInfoServiceTest {
    @Resource
    private AppInfoService appInfoService;

    @Test
    public void queryAppInfoListConditionForPageAndCountTest() {
        AppInfo appInfo = new AppInfo();
        appInfo.setSoftwareName("");
        appInfo.setFlatFormId(null);
        appInfo.setCategoryLevel1(null);
        appInfo.setCategoryLevel2(null);
        appInfo.setCategoryLevel3(null);
        Map<String, String> map = new HashMap<>();
        map.put("softwareName", "王者");
        map.put("flatFormId", "");
        map.put("categoryLevel1", "");
        map.put("categoryLevel2", "");
        map.put("categoryLevel3", "");
        map.put("current", "1");
        map.put("pageSize", "5");
        PageInfo<AppInfo> appInfoPageInfo = appInfoService.queryAppInfoListConditionForPageAndCount(map);
        System.out.println(appInfoPageInfo);
    }

    @Test
    public void queryAppInfoByIdTest() {
        AppInfo appInfo = appInfoService.queryAppInfoById(62L);
        System.out.println("appInfo = " + appInfo);
    }


    @Test
    public void queryAppInfoAllTest() {
        List<AppInfo> appInfos = appInfoService.queryAppInfoAll();
        String str = "/BeyondPlatform/platform/platform_web/src/main/webapp/statics/uploadfiles/";
        for (AppInfo appInfo : appInfos) {
            String logoPicPath = appInfo.getLogoPicPath();
            String s = logoPicPath.substring(logoPicPath.lastIndexOf("/")-8);
            System.out.println("s = " + s);
        }
    }
}
