package com.platform.developer.controller;

import cn.hutool.json.JSONUtil;
import com.github.pagehelper.PageInfo;
import com.platform.Vo.Result;
import com.platform.backend.entity.AppCategory;
import com.platform.backend.entity.AppInfo;
import com.platform.backend.entity.Dictionary;
import com.platform.backend.service.AppCategoryService;
import com.platform.backend.service.AppInfoService;
import com.platform.backend.service.AppVersionService;
import com.platform.backend.service.DictionaryService;
import com.platform.constant.CommonsEnum;
import com.platform.developer.entity.DevUser;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * Copyright (C), 2017-2022, RainGrd
 * Author: lenovo
 * Date: 2022/11/7 8:37
 * FileName: AppInfoListController
 * Description: 手游应用展示控制层
 */
@Controller
public class AppInfoListController {
    @Resource
    private DictionaryService dictionaryService;
    @Resource
    private AppCategoryService appCategoryService;
    @Resource
    private AppInfoService appInfoService;
    @Resource
    private AppVersionService appVersionService;

    /**
     * 用于跳转至手游列表展示页面
     *
     * @return
     */
    @RequestMapping("/developer/toAppInfoList.do")
    public ModelAndView toAppInfoList() {
        ModelAndView modelAndView = new ModelAndView();
        // 查询手游状态
        List<Dictionary> statusList = dictionaryService.queryByTypeCodeDictionaryList("APP_STATUS");
        //查询数据字典
        List<Dictionary> dictionaryList = dictionaryService.queryByTypeCodeDictionaryList("APP_FLATFORM");
        //查询应用分类
        String[] categoryLevel1Arr = {"1", "2",};
        String[] categoryLevel2Arr = {"3", "4", "5", "19", "20", "21", "22", "23", "24", "25", "26", "28", "41", "42", "43",};
        String[] categoryLevel3Arr = {"48", "52", "53", "54", "55", "56", "57", "58", "44", "45", "46", "47", "49", "50", "51", "59", "120", "119", "118", "117", "116", "112", "111", "110", "109", "115", "114", "113", "121", "122", "123",};
        List<AppCategory> categoryLevel1List = appCategoryService.queryAppCategoryListByLevels(categoryLevel1Arr);
        List<AppCategory> categoryLevel2List = appCategoryService.queryAppCategoryListByLevels(categoryLevel2Arr);
        List<AppCategory> categoryLevel3List = appCategoryService.queryAppCategoryListByLevels(categoryLevel3Arr);
        // 添加数据
        modelAndView.addObject("statusList", statusList);
        modelAndView.addObject("dictionaryList", dictionaryList);
        modelAndView.addObject("categoryLevel1List", categoryLevel1List);
        modelAndView.addObject("categoryLevel2List", categoryLevel2List);
        modelAndView.addObject("categoryLevel3List", categoryLevel3List);
        modelAndView.setViewName("developer/appinfolist");
        return modelAndView;
    }

    /**
     * 根据分类父级节点id来查询
     */
    @RequestMapping("/developer/getAppCategoryLevelList.do")
    @ResponseBody
    public String getAppCategoryLevelList(@RequestParam("parentId") Long parentId) {
        System.out.println("parentId = " + parentId);
        List<AppCategory> appCategories = appCategoryService.queryAppCategoryListByParentId(parentId);
        System.out.println("appCategories = " + appCategories);
        return JSONUtil.toJsonStr(appCategories);
    }

    /**
     * 分页查询
     *
     * @param map
     * @return
     */
    @PostMapping("/developer/queryAppInfoListConditionForPageAndCount.do")
    @ResponseBody
    public String queryAppInfoListConditionForPageAndCount(@RequestBody Map<String, String> map) {
        System.out.println("map = " + map);
        //查询应用分类
        PageInfo<AppInfo> appInfoPageInfo = appInfoService.queryAppInfoListConditionForPageAndCount(map);
        System.out.println("appInfoPageInfo = " + appInfoPageInfo);
        return JSONUtil.toJsonStr(appInfoPageInfo);
    }

    /**
     * 跳转至新增手游基础信息
     *
     * @return
     */
    @RequestMapping("/developer/toAppinfoadd.do")
    public ModelAndView toAppinfoadd() {
        ModelAndView modelAndView = new ModelAndView();
        //查询数据字典
        List<Dictionary> dictionaryList = dictionaryService.queryByTypeCodeDictionaryList("APP_FLATFORM");
        //查询应用分类
        String[] categoryLevel1Arr = {"1", "2",};
        String[] categoryLevel2Arr = {"3", "4", "5", "19", "20", "21", "22", "23", "24", "25", "26", "28", "41", "42", "43",};
        String[] categoryLevel3Arr = {"48", "52", "53", "54", "55", "56", "57", "58", "44", "45", "46", "47", "49", "50", "51", "59", "120", "119", "118", "117", "116", "112", "111", "110", "109", "115", "114", "113", "121", "122", "123",};
        List<AppCategory> categoryLevel1List = appCategoryService.queryAppCategoryListByLevels(categoryLevel1Arr);
        List<AppCategory> categoryLevel2List = appCategoryService.queryAppCategoryListByLevels(categoryLevel2Arr);
        List<AppCategory> categoryLevel3List = appCategoryService.queryAppCategoryListByLevels(categoryLevel3Arr);
        modelAndView.addObject("categoryLevel1List", categoryLevel1List);
        modelAndView.addObject("dictionaryList", dictionaryList);
        modelAndView.addObject("categoryLevel2List", categoryLevel2List);
        modelAndView.addObject("categoryLevel3List", categoryLevel3List);
        modelAndView.setViewName("developer/appinfoadd");
        return modelAndView;
    }

    /**
     * 删除手游
     *
     * @param id
     * @return
     */
    @RequestMapping("/developer/deleteAppInfo.do")
    @ResponseBody
    public Object deleteAppInfo(@RequestParam Long id) {
        try {
            //更新手游基础信息表（app_info）
            int deleteAppInfo = appInfoService.deleteAppInfo(id);
            //更新手游版本信息表（app_version）
            int deleteAppVersionByAppInfoId = appVersionService.deleteAppVersionByAppInfoId(id);

            if (deleteAppInfo <= 0 && deleteAppVersionByAppInfoId <= 0) {
                return Result.fail("删除失败！");
            }

        } catch (Exception e) {
            e.printStackTrace();
            return Result.fail("系统正在维护中！");
        }
        return Result.ok("删除成功！");
    }

    /**
     * 上架或者下架手游
     *
     * @param appId
     * @param session
     * @return
     */

    @RequestMapping(value = "/developer/sale.do")
    public @ResponseBody Object sale(@RequestParam(value = "appId") Long appId, HttpSession session) {
        System.out.println("appId = " + appId);
        AppInfo appInfo = appInfoService.queryAppInfoById(appId);
        DevUser devUser = (DevUser) session.getAttribute(CommonsEnum.SESSION_DEVELOPER_USER.getValue());
        //封装数据
        appInfo.setModifyBy(devUser.getId());
        appInfo.setModifyDate(new Date());
        try {
            int updateAppInfoByAppInfo = appInfoService.updateAppInfoByAppInfo(appInfo);
            if (updateAppInfoByAppInfo <= 0) {
                return Result.fail("");
            }
        } catch (Exception e) {
            e.printStackTrace();
            return Result.fail("系统正在维护中！");
        }
        return Result.ok();
    }


}
