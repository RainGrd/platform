package com.platform.backend.service;

import com.platform.backend.entity.AppVersion;

import java.util.Map;

/**
 * @author lenovo
 * @description 针对表【t_app_version】的数据库操作Service
 * @createDate 2022-10-31 10:46:41
 */
public interface AppVersionService {
    /**
     * 根据versionid查询
     */
    AppVersion queryAppVersionByVersionId(Long versionId);

    /**
     * 根据AppId进行更新
     *
     * @param map
     * @return
     */
    int updateAppVersionByAppId(Map<String, String> map);

    AppVersion queryAppVersionByAppId(Long appId);

    int deleteApk(Long appId);
}
