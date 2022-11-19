package com.platform.developer.controller;

import cn.hutool.core.lang.UUID;
import com.platform.Vo.Result;
import com.platform.backend.entity.AppInfo;
import com.platform.backend.entity.AppVersion;
import com.platform.backend.service.AppInfoService;
import com.platform.backend.service.AppVersionService;
import com.platform.constant.CommonsEnum;
import com.platform.developer.entity.DevUser;
import com.platform.util.CommonUtil;
import com.platform.util.FileUtils;
import com.platform.util.UUIDUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.Date;
import java.util.List;

/**
 * Copyright (C), 2017-2022, RainGrd
 * Author: lenovo
 * Date: 2022/11/8 14:13
 * FileName: AppVersionAddController
 * Description:
 */
@Controller
public class AppVersionAddController {

    @Resource
    private AppVersionService appVersionService;
    @Resource
    private AppInfoService appInfoService;

    /**
     * 跳转至新增版本页面
     *
     * @param id
     * @return
     */
    @RequestMapping("/developer/toAppVersionAdd.do")
    public ModelAndView toAppVersionAdd(@RequestParam Long id) {
        ModelAndView modelAndView = new ModelAndView();
        List<AppVersion> appVersionList = appVersionService.queryAppVersionByAppId(id);
        AppInfo appInfo = appInfoService.queryAppInfoById(id);
        modelAndView.addObject("appVersionList", appVersionList);
        modelAndView.addObject("appInfo", appInfo);
        modelAndView.setViewName("developer/appversionadd");
        return modelAndView;
    }

    /**
     * 新增版本
     *
     * @param appVersion
     * @param file
     * @param request
     * @param session
     * @return
     */
    @RequestMapping("/developer/insertAppVersion.do")
    @ResponseBody
    public Object insertAppVersion(AppVersion appVersion, MultipartFile file, HttpServletRequest request, HttpSession session) {
        // 取出开发者用户对象
        DevUser devUser = (DevUser) session.getAttribute(CommonsEnum.SESSION_DEVELOPER_USER.getValue());
        try {
            String upload = FileUtils.upload(request, file);
            System.out.println("upload = " + upload);
            //封装数据
            appVersion.setId(UUIDUtils.getUUID());
            appVersion.setCreatedBy(String.valueOf(devUser.getId()));
            appVersion.setCreationDate(new Date());
            System.out.println(CommonUtil.setFileAbsPath(request));
            System.out.println("CommonUtil.strReplace(upload) = " + CommonUtil.strReplace(upload));
            appVersion.setApkLocPath(CommonUtil.setFileAbsPath(request) + CommonUtil.strReplace(upload));
            appVersion.setApkFileName(file.getOriginalFilename());
            appVersion.setDownloadLink(upload);
            int i = appVersionService.createAppVersion(appVersion);
            List<AppVersion> appVersions = appVersionService.getAppVersionListByAppId(Long.valueOf(appVersion.getAppId()));
            appVersion = appVersions.get(appVersions.size() - 1);
            System.out.println("appVersions = " + appVersions);
            //更新手游基础信息表的version_id
            AppInfo appInfo = new AppInfo();
            appInfo.setModifyBy(devUser.getId());
            appInfo.setModifyDate(new Date());
            appInfo.setVersionId(appVersion.getId());
            appInfo.setId(appVersion.getAppId());
            int modifyAppInfo = appInfoService.modifyAppInfoByAppInfo(appInfo);
            if (i <= 0) {
                return Result.fail("新增版本失败！");
            }
        } catch (Exception e) {
            e.printStackTrace();
            return Result.fail("系统正在维护中！");
        }
        return Result.ok();
    }

}
