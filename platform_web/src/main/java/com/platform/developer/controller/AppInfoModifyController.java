package com.platform.developer.controller;

import com.platform.Vo.Result;
import com.platform.backend.entity.AppInfo;
import com.platform.backend.entity.Dictionary;
import com.platform.backend.service.AppInfoService;
import com.platform.backend.service.AppVersionService;
import com.platform.backend.service.DictionaryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import java.io.File;
import java.util.List;

/**
 * Copyright (C), 2017-2022, RainGrd
 * Author: lenovo
 * Date: 2022/11/7 18:01
 * FileName: AppInfoModifyController
 * Description: 修改手游应用信息的控制层
 */
@Controller
public class AppInfoModifyController {

    @Resource
    private DictionaryService dictionaryService;
    @Autowired
    private AppInfoService appInfoService;

    @Autowired
    private AppVersionService appVersionService;

    /**
     * 跳转至修改页面
     *
     * @param id
     * @return
     */
    @RequestMapping("/developer/toAppInfoModify.do")
    public ModelAndView toAppInfoModify(@RequestParam Long id) {
        ModelAndView modelAndView = new ModelAndView();
        AppInfo appInfo = appInfoService.queryAppInfoById(id);
        List<Dictionary> dictionaryList = dictionaryService.queryByTypeCodeDictionaryList("APP_FLATFORM");
        modelAndView.addObject("dictionaryList", dictionaryList);
        modelAndView.addObject("appInfo", appInfo);
        modelAndView.setViewName("developer/appinfomodify");
        return modelAndView;
    }

    @RequestMapping("/developer/delFile.do")
    @ResponseBody
    public Object delFile(@RequestParam Long id, @RequestParam String flag) {
        if (flag == null || "".equals(flag) || id == null) {
            return Result.fail("删除失败！");
        }
        File file = null;
        if ("logo".equals(flag)) {
            //删除服务器存放的图片文件
            String logoLocPath = appInfoService.queryAppInfoById(id).getLogoLocPath();
            file = new File(logoLocPath);
            if (!file.exists()) {
                return Result.fail("文件不存在");
            }
            if (file.delete()) {
                try {
                    //删除logo的数据
                    int logo = appInfoService.deleteLogo(id);
                    if (logo <= 0) {
                        return Result.fail("文件不存在!");
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                    return Result.fail("系统正在维护中！");
                }
            }
        } else if ("apk".equals(flag)) {
            String apkLocPath = appVersionService.queryAppVersionByAppId(id).getApkLocPath();
            file = new File(apkLocPath);
            if (!file.exists()) {
                return Result.fail("文件不存在！");
            }
            if (file.delete()) {
                try {
                    //删除logo的数据
                    int apk = appVersionService.deleteApk(id);
                    if (apk <= 0) {
                        return Result.fail("文件不存在!");
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                    return Result.fail("系统正在维护中！");
                }
            }
        }
        return Result.ok("删除成功！");
    }
}
