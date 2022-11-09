package com.platform.backend.service;

import com.github.pagehelper.PageInfo;
import com.platform.backend.entity.AppInfo;

import java.util.List;
import java.util.Map;

/**
 * Copyright (C), 2017-2022, RainGrd
 * Author: lenovo
 * Date: 2022/10/31 10:57
 * FileName: AppInfoService
 * Description:
 */
public interface AppInfoService {

    PageInfo<AppInfo> queryAppListConditionForPageAndCount(Map<String, String> map);

    PageInfo<AppInfo> queryAppInfoListConditionForPageAndCount(Map<String, String> map);

    List<AppInfo> queryAppInfoListConditionForPage(Map<String, String> map);

    int queryAppInfoListConditionForCount(Map<String, String> map);

    /**
     * 根据appInfo查询数据
     *
     * @param appInfoId
     * @return
     */
    AppInfo queryAppInfoById(Long appInfoId);

    /**
     * 查询全部
     *
     * @return
     */
    List<AppInfo> queryAppInfoAll();

    /**
     * 根据id修改app的状态值
     */
    int modifyAppInfoStatusById(Map<String,String> map);

    boolean apkNameExist(String apkName);

    int addAppInfo(AppInfo appInfo);

    int deleteLogo(Long id);

    int modifyAppInfoByAppInfoId(AppInfo appInfo);
}
