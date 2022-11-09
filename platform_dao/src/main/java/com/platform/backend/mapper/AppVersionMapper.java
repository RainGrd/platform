package com.platform.backend.mapper;

import com.platform.backend.entity.AppVersion;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

/**
 * @author lenovo
 * @description 针对表【t_app_version】的数据库操作Mapper
 * @createDate 2022-10-31 10:46:41
 * @Entity com.platform.backend.entity.AppVersion
 */
public interface AppVersionMapper {

    /**
     * 根据id查询数据appVerison
     */
    AppVersion selectAppVersionByVersionId(@Param("versionId") Long version);

    /**
     * 根据AppId进行更新
     *
     * @param appVersion
     * @return
     */
    int updateAppVersionByAppId(@Param("appVersion") Map<String, String> map);

    /**
     * 新增版本
     *
     * @param appVersion
     * @return
     */
    int insertAppVersion(@Param("appVersion") AppVersion appVersion);

    List<AppVersion> selectAppVersionByAppId(Long appId);


    List<AppVersion> selectAppVersionListByAppId(Long appId);


    int deleteApk(Long appId);

    int updateAppVersion(@Param("appVersion") AppVersion appVersion);
}




