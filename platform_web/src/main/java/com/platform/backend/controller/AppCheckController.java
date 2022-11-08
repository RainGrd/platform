package com.platform.backend.controller;

import com.platform.Vo.Result;
import com.platform.backend.entity.AppInfo;
import com.platform.backend.entity.AppVersion;
import com.platform.backend.service.AppInfoService;
import com.platform.backend.service.AppVersionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import javax.xml.ws.Action;
import java.util.Map;

/**
 * Copyright (C), 2017-2022, RainGrd
 * Author: lenovo
 * Date: 2022/11/1 16:51
 * FileName: AppCheckController
 * Description: 审核控制层
 */
@Controller
public class AppCheckController {

    @Resource
    private AppInfoService appInfoService;
    @Autowired
    private AppVersionService appVersionService;

    /**
     * 跳转至审核页面
     *
     * @param appInfoId
     * @param versionId
     * @return
     */
    @RequestMapping("/backend/toAppCheck.do")
    public ModelAndView toAppCheck(@RequestParam Long appInfoId, @RequestParam Long versionId) {
        ModelAndView modelAndView = new ModelAndView();
        // 查询数据
        AppInfo appInfo = appInfoService.queryAppInfoById(appInfoId);
        System.out.println("appInfo = " + appInfo);
        AppVersion appVersion = appVersionService.queryAppVersionByVersionId(versionId);
        System.out.println("appVersion = " + appVersion);
        // 添加数据
        modelAndView.addObject("appInfo", appInfo);
        modelAndView.addObject("appVersion", appVersion);
        // 跳转页面
        modelAndView.setViewName("/backend/appcheck");
        return modelAndView;
    }

    /**
     * 进行app审核操作
     *
     * @param
     * @return
     */
    @RequestMapping("/backend/appCheck.do")
    @ResponseBody
    public Object appCheck(@RequestBody Map<String, String> map) {
        System.out.println("map = " + map);
        try {
            int modifyAppInfoStatusById = appInfoService.modifyAppInfoStatusById(map);
            System.out.println("modifyAppInfoStatusById = " + modifyAppInfoStatusById);
            int updateAppVersionByAppId = appVersionService.updateAppVersionByAppId(map);
            System.out.println("updateAppVersionByAppId = " + updateAppVersionByAppId);
            if (modifyAppInfoStatusById <= 0 || updateAppVersionByAppId <= 0) {
                return Result.ok("审核不通过");
            }
        } catch (Exception e) {
            e.printStackTrace();
            return Result.fail("系统正在进行维修");
        }
        return Result.ok("审核通过！");
    }


}
