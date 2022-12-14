package com.platform.backend.mapper;

import com.platform.backend.entity.AppInfo;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

public interface AppInfoMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_app_info
     *
     * @mbggenerated Mon Oct 31 10:49:49 CST 2022
     */
    int deleteByPrimaryKey(Long id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_app_info
     *
     * @mbggenerated Mon Oct 31 10:49:49 CST 2022
     */
    int insert(AppInfo record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_app_info
     *
     * @mbggenerated Mon Oct 31 10:49:49 CST 2022
     */
    int insertSelective(AppInfo record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_app_info
     *
     * @mbggenerated Mon Oct 31 10:49:49 CST 2022
     */
    AppInfo selectByPrimaryKey(Long id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_app_info
     *
     * @mbggenerated Mon Oct 31 10:49:49 CST 2022
     */
    int updateByPrimaryKeySelective(AppInfo record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_app_info
     *
     * @mbggenerated Mon Oct 31 10:49:49 CST 2022
     */
    int updateByPrimaryKey(AppInfo record);

    /**
     * 根据分页条件查询全部appList的信息
     */
    List<AppInfo> selectAppListConditionForPage(@Param("map") Map<String, String> map);

    /**
     * 根据分页条件查询全部appList的条数
     */
    int selectAppListConditionForCount(@Param("map") Map<String, String> map);

    /**
     * 根据分页条件查询全部appInfoList的信息
     */
    List<AppInfo> selectAppInfoListConditionForPage(@Param("map") Map<String, String> map);

    /**
     * 根据分页条件查询全部appInfoList的条数
     */
    int selectAppInfoListConditionForCount(@Param("map") Map<String, String> map);

    /**
     * 根据id查询appInfo对象
     *
     * @param appInfoId
     * @return
     */
    AppInfo selectAppInfoById(Long appInfoId);

    /**
     * 查询全部
     *
     * @return
     */
    List<AppInfo> selectAll();

    /**
     * 插入appinfo对象
     *
     * @param appInfo
     * @return
     */
    int insertAppInfo(@Param("appInfo") AppInfo appInfo);

    /**
     * 根据id修改信息
     */
    int updateAppInfoStatusById(@Param("appInfo") Map<String, String> map);


    AppInfo selectAppInfoByApkName(@Param("apkName") String apkName);

    int deleteLogoById(Long id);

    int updateAppInfo(@Param("appInfo") AppInfo appInfo);

    int deleteAppInfoById(Long appInfoId);
}