package com.platform.developer.controller;

import com.platform.Vo.Result;
import com.platform.backend.entity.AppInfo;
import com.platform.backend.service.AppInfoService;
import com.platform.constant.CommonsEnum;
import com.platform.developer.entity.DevUser;
import com.platform.util.CommonUtil;
import com.platform.util.FileUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.Date;

/**
 * Copyright (C), 2017-2022, RainGrd
 * Author: lenovo
 * Date: 2022/11/7 13:23
 * FileName: AppInfoAddController
 * Description:
 */
@Controller
public class AppInfoAddController {

    @Resource
    private AppInfoService appInfoService;

    /**
     * 验证APKName是否已存在
     *
     * @param apkName
     * @return
     */
    @GetMapping("/developer/apkexist.do")
    @ResponseBody
    public Object apkexist(@RequestParam String apkName) {
        boolean flag = appInfoService.apkNameExist(apkName);
        return flag ? Result.fail("apk已经存在") : Result.ok();
    }

    /**
     * @param multipartFile
     * @return
     */
    @PostMapping("/developer/imgUpload.do")
    @ResponseBody
    public Result imgUpload(HttpServletRequest request, MultipartFile multipartFile) throws IOException {
        if (multipartFile == null) {
            Result.fail("文件不能为空！");
        }
        //上传图片
        String upload = FileUtils.upload(request, multipartFile);
        System.out.println("upload = " + upload);
        // 封装数据
        AppInfo appInfo = new AppInfo();
        //插入数据库
        return Result.ok();
    }

    /**
     * 新增手游应用信息
     *
     * @return
     */
    @PostMapping("/developer/insertSend.do")
    @ResponseBody
    public Result insertSend(AppInfo appInfo, MultipartFile file, HttpServletRequest request, HttpSession session) throws IOException {
        System.out.println("appInfo = " + appInfo);
        System.out.println("file = " + file);
        //上传图片
        String upload = FileUtils.upload(request, file);
        System.out.println("upload = " + upload);
        // 封装数据
        DevUser devUser = (DevUser) session.getAttribute(CommonsEnum.SESSION_DEVELOPER_USER.getValue());
        appInfo.setDevId(devUser.getId());
        appInfo.setCreatedBy(devUser.getId());
        appInfo.setCreationDate(new Date());
        appInfo.setLogoPicPath(upload);
        appInfo.setVersionId(33L);
        //获取项目绝对路径
        String absPath = CommonUtil.setFileAbsPath(request);
        appInfo.setLogoLocPath(absPath + upload);
        //插入数据
        try {
            int i = appInfoService.addAppInfo(appInfo);
            if (i <= 0) {
                return Result.fail("保存失败");
            }
        } catch (Exception e) {
            e.printStackTrace();
            return Result.fail("系统正在维护");
        }
        return Result.ok();
    }
}
