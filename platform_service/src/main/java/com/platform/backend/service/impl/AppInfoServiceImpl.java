package com.platform.backend.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.platform.backend.entity.AppInfo;
import com.platform.backend.entity.AppVersion;
import com.platform.backend.mapper.AppInfoMapper;
import com.platform.backend.mapper.AppVersionMapper;
import com.platform.backend.service.AppInfoService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;

/**
 * Copyright (C), 2017-2022, RainGrd
 * Author: lenovo
 * Date: 2022/10/31 10:57
 * FileName: AppInfoServiceImpl
 * Description:
 */
@Service
public class AppInfoServiceImpl implements AppInfoService {

    @Resource
    private AppInfoMapper appInfoMapper;
    @Resource
    private AppVersionMapper appVersionMapper;

    public PageInfo<AppInfo> queryAppListConditionForPageAndCount(Map<String, String> map) {
        int current = Integer.parseInt(map.get("current"));
        int pageSize = Integer.parseInt(map.get("pageSize"));
        PageHelper.startPage(current, pageSize);
        List<AppInfo> appInfos = appInfoMapper.selectAppListConditionForPage(map);
        int count = appInfoMapper.selectAppListConditionForCount(map);
        return new PageInfo<AppInfo>(appInfos, count);
    }

    @Override
    public PageInfo<AppInfo> queryAppInfoListConditionForPageAndCount(Map<String, String> map) {
        int current = Integer.parseInt(map.get("current"));
        int pageSize = Integer.parseInt(map.get("pageSize"));
        PageHelper.startPage(current, pageSize);
        List<AppInfo> appInfos = appInfoMapper.selectAppInfoListConditionForPage(map);
        int count = appInfoMapper.selectAppInfoListConditionForCount(map);
        return new PageInfo<AppInfo>(appInfos, count);
    }

    @Override
    public List<AppInfo> queryAppInfoListConditionForPage(Map<String, String> map) {
        return appInfoMapper.selectAppListConditionForPage(map);
    }

    @Override
    public int queryAppInfoListConditionForCount(Map<String, String> map) {
        return appInfoMapper.selectAppListConditionForCount(map);
    }

    @Override
    public AppInfo queryAppInfoById(Long appInfoId) {
        return appInfoMapper.selectAppInfoById(appInfoId);
    }

    @Override
    public List<AppInfo> queryAppInfoAll() {
        return appInfoMapper.selectAll();
    }

    @Override
    public int modifyAppInfoStatusById(Map<String, String> map) {
        //封装数据

        return appInfoMapper.updateAppInfoStatusById(map);

    }

    @Override
    public boolean apkNameExist(String apkName) {
        AppInfo appInfo = appInfoMapper.selectAppInfoByApkName(apkName);
        return appInfo != null;
    }

    @Override
    public int addAppInfo(AppInfo appInfo) {
        //封装数据
        AppVersion appVersion = new AppVersion();
        appVersion.setAppId(appInfo.getId());
        appVersion.setVersionNo("V1.1.1");
        appVersion.setVersionInfo("V1.1.1版本简介");
        appVersion.setPublishStatus(3L);
        appVersion.setDownloadLink("statics/uploadfiles/" + appInfo.getApkName() + "-V1.1.2.apk");
        appVersion.setVersionSize(new BigDecimal(1));
        appVersion.setCreatedBy(appInfo.getId());
        appVersion.setCreationDate(LocalDateTime.now());
        appVersion.setApkLocPath("D:/materials/BeyondPlatform/platform/platform_web/src/main/webapp/statics/uploadfiles" + appInfo.getApkName() + "-V1.1.2.apk");
        appVersion.setApkFileName(appInfo.getApkName() + appVersion.getVersionNo() + ".apk");
        //新增版本
        appVersionMapper.insertAppVersion(appVersion);
        return appInfoMapper.insertAppInfo(appInfo);
    }

    @Override
    public int deleteLogo(Long id) {
        return appInfoMapper.deleteLogoById(id);
    }
}
