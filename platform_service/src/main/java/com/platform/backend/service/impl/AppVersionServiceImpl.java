package com.platform.backend.service.impl;

import com.platform.backend.entity.AppInfo;
import com.platform.backend.entity.AppVersion;
import com.platform.backend.mapper.AppInfoMapper;
import com.platform.backend.service.AppInfoService;
import com.platform.backend.service.AppVersionService;
import com.platform.backend.mapper.AppVersionMapper;
import com.platform.util.DateTimeUtil;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

/**
 * @author lenovo
 * @description 针对表【t_app_version】的数据库操作Service实现
 * @createDate 2022-10-31 10:46:41
 */
@Service
public class AppVersionServiceImpl implements AppVersionService {
    @Resource
    private AppVersionMapper appVersionMapper;


    @Resource
    private AppInfoMapper appInfoMapper;

    @Override
    public AppVersion queryAppVersionByVersionId(Long versionId) {
        AppVersion appVersion = appVersionMapper.selectAppVersionByVersionId(versionId);
        appVersion.setVersionInfo(appVersion.getVersionInfo().trim());
        return appVersion;
    }

    @Override
    public int updateAppVersionByAppId(Map<String, String> map) {
        return appVersionMapper.updateAppVersionByAppId(map);
    }

    @Override
    public List<AppVersion> queryAppVersionByAppId(Long appId) {
        return appVersionMapper.selectAppVersionByAppId(appId);
    }

    @Override
    public List<AppVersion> getAppVersionListByAppId(Long appId) {
        return appVersionMapper.selectAppVersionListByAppId(appId);
    }

    @Override
    public int deleteApk(Long appId) {
        return appVersionMapper.deleteApk(appId);
    }

    @Override
    public int createAppVersion(AppVersion appVersion) {

        return appVersionMapper.insertAppVersion(appVersion);
    }

    @Override
    public int modifyAppVersion(AppVersion appVersion) {
        return appVersionMapper.updateAppVersion(appVersion);
    }
}




