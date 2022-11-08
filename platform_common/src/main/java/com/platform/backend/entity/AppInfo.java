package com.platform.backend.entity;

import lombok.Data;
import org.apache.ibatis.type.Alias;

import java.math.BigDecimal;
import java.util.Date;

@Data
@Alias("appInfo")
public class AppInfo {
    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_app_info.id
     *
     * @mbggenerated Mon Oct 31 10:49:49 CST 2022
     */
    private Long id;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_app_info.software_name
     *
     * @mbggenerated Mon Oct 31 10:49:49 CST 2022
     */
    private String softwareName;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_app_info.APK_name
     *
     * @mbggenerated Mon Oct 31 10:49:49 CST 2022
     */
    private String apkName;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_app_info.supportROM
     *
     * @mbggenerated Mon Oct 31 10:49:49 CST 2022
     */
    private String supportROM;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_app_info.interfaceLanguage
     *
     * @mbggenerated Mon Oct 31 10:49:49 CST 2022
     */
    private String interfaceLanguage;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_app_info.softwareSize
     *
     * @mbggenerated Mon Oct 31 10:49:49 CST 2022
     */
    private BigDecimal softwareSize;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_app_info.updateDate
     *
     * @mbggenerated Mon Oct 31 10:49:49 CST 2022
     */
    private Date updateDate;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_app_info.devId
     *
     * @mbggenerated Mon Oct 31 10:49:49 CST 2022
     */
    private Long devId;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_app_info.appInfo
     *
     * @mbggenerated Mon Oct 31 10:49:49 CST 2022
     */
    private String appInfo;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_app_info.status
     *
     * @mbggenerated Mon Oct 31 10:49:49 CST 2022
     */
    private Long status;
    /**
     *
     */
    private String statusName;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_app_info.onSaleDate
     *
     * @mbggenerated Mon Oct 31 10:49:49 CST 2022
     */
    private Date onSaleDate;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_app_info.offSaleDate
     *
     * @mbggenerated Mon Oct 31 10:49:49 CST 2022
     */
    private Date offSaleDate;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_app_info.flatFormId
     *
     * @mbggenerated Mon Oct 31 10:49:49 CST 2022
     */
    private Long flatFormId;

    private String flatFormName;
    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_app_info.categoryLevel3
     *
     * @mbggenerated Mon Oct 31 10:49:49 CST 2022
     */
    private Long categoryLevel3;

    private String categoryLevel3Name;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_app_info.downloads
     *
     * @mbggenerated Mon Oct 31 10:49:49 CST 2022
     */
    private Long downloads;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_app_info.createdBy
     *
     * @mbggenerated Mon Oct 31 10:49:49 CST 2022
     */
    private Long createdBy;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_app_info.creationDate
     *
     * @mbggenerated Mon Oct 31 10:49:49 CST 2022
     */
    private Date creationDate;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_app_info.modifyBy
     *
     * @mbggenerated Mon Oct 31 10:49:49 CST 2022
     */
    private Long modifyBy;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_app_info.modifyDate
     *
     * @mbggenerated Mon Oct 31 10:49:49 CST 2022
     */
    private Date modifyDate;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_app_info.categoryLevel1
     *
     * @mbggenerated Mon Oct 31 10:49:49 CST 2022
     */
    private Long categoryLevel1;
    private String categoryLevel1Name;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_app_info.categoryLevel2
     *
     * @mbggenerated Mon Oct 31 10:49:49 CST 2022
     */
    private Long categoryLevel2;

    private String categoryLevel2Name;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_app_info.logoPicPath
     *
     * @mbggenerated Mon Oct 31 10:49:49 CST 2022
     */
    private String logoPicPath;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_app_info.logoLocPath
     *
     * @mbggenerated Mon Oct 31 10:49:49 CST 2022
     */
    private String logoLocPath;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_app_info.versionId
     *
     * @mbggenerated Mon Oct 31 10:49:49 CST 2022
     */
    private Long versionId;

    private String versionName;

    private Integer devStatus;

    /**
     * 字典实体
     */
//    private Dictionary dictionary;
    /**
     * APP版本实体
     */
//    private AppVersion appVersion;
    /**
     * app类别实体
     */
//    private AppCategory appCategory;

}