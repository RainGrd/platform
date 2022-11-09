package com.platform.developer.controller;

import com.platform.backend.entity.AppInfo;
import com.platform.backend.entity.AppVersion;
import com.platform.backend.service.AppInfoService;
import com.platform.backend.service.AppVersionService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import java.util.List;

/**
 * Copyright (C), 2017-2022, RainGrd
 * Author: lenovo
 * Date: 2022/11/9 10:28
 * FileName: AppinfoViewController
 * Description:
 */
@Controller
public class AppInfoViewController {
    @Resource
    private AppInfoService appInfoService;

    @Resource
    private AppVersionService appVersionService;

    /**
     * 跳转至查看页面
     * @param appInfoId
     * @return
     */
    @RequestMapping("/developer/toAppInfoView.do")
    public ModelAndView toAppInfoView(@RequestParam("appInfoId") Long appInfoId) {
        System.out.println("appInfoId = " + appInfoId);
        ModelAndView modelAndView = new ModelAndView();
        AppInfo appInfo = appInfoService.queryAppInfoById(appInfoId);
        List<AppVersion> appVersionList = appVersionService.queryAppVersionByAppId(appInfoId);
        modelAndView.addObject("appInfo", appInfo);
        modelAndView.addObject("appVersionList", appVersionList);
        modelAndView.setViewName("/developer/appinfoview");
        return modelAndView;
    }
}
