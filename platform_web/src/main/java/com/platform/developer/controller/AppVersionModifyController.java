package com.platform.developer.controller;

import com.platform.Vo.Result;
import com.platform.backend.entity.AppInfo;
import com.platform.backend.entity.AppVersion;
import com.platform.backend.service.AppInfoService;
import com.platform.backend.service.AppVersionService;
import com.platform.constant.CommonsEnum;
import com.platform.developer.entity.DevUser;
import com.platform.util.CommonUtil;
import com.platform.util.FileUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

/**
 * Copyright (C), 2017-2022, RainGrd
 * Author: lenovo
 * Date: 2022/11/8 17:05
 * FileName: AppVersionModifyController
 * Description: 修改手游应用版本控制层
 */
@Controller
public class AppVersionModifyController {

    @Resource
    private AppVersionService appVersionService;
    @Resource
    private AppInfoService appInfoService;


    /**
     * 跳转至修改版本页面
     *
     * @param id
     * @return
     */
    @RequestMapping("/developer/toAppVersionModify.do")
    public ModelAndView toAppVersionModify(@RequestParam Long versionId, @RequestParam Long appInfoId) {
        ModelAndView modelAndView = new ModelAndView();
        List<AppVersion> appVersionList = appVersionService.queryAppVersionByAppId(appInfoId);
        AppVersion appVersion = appVersionService.queryAppVersionByVersionId(versionId);
        modelAndView.addObject("appVersionList", appVersionList);
        modelAndView.addObject("appVersion", appVersion);
        modelAndView.setViewName("developer/appversionmodify");
        return modelAndView;
    }

    /**
     * 修改手游信息
     * @param appVersion
     * @param file
     * @param request
     * @param session
     * @return
     */
    @PostMapping("/developer/appVersionModifySend.do")
    @ResponseBody
    public Object appVersionModifySend(AppVersion appVersion, MultipartFile file, HttpServletRequest request, HttpSession session) {
        DevUser devUser = (DevUser) session.getAttribute(CommonsEnum.SESSION_DEVELOPER_USER.getValue());
        try {
            //如果文件不为空
            if (file != null) {
                String upload = FileUtils.upload(request, file);
                //封装数据
                appVersion.setModifyBy(devUser.getId());
                appVersion.setModifyDate(new Date());
                appVersion.setApkFileName(file.getOriginalFilename());
                appVersion.setApkLocPath(CommonUtil.setFileAbsPath(request) + CommonUtil.strReplace(upload));
            }
            int i = appVersionService.modifyAppVersion(appVersion);
            //如果没有更新成功！
            if (i <= 0) {
                //返回错误提示
                return Result.fail("修改失败！");
            }
        } catch (Exception e) {
            e.printStackTrace();
            return Result.fail("系统正在维护中！");
        }
        return Result.ok();
    }

}
