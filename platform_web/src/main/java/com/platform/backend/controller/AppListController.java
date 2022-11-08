package com.platform.backend.controller;

import cn.hutool.json.JSONUtil;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.github.pagehelper.PageInfo;
import com.platform.backend.entity.AppCategory;
import com.platform.backend.entity.AppInfo;
import com.platform.backend.entity.Dictionary;
import com.platform.backend.service.AppCategoryService;
import com.platform.backend.service.AppInfoService;
import com.platform.backend.service.DictionaryService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Copyright (C), 2017-2022, RainGrd
 * Author: lenovo
 * Date: 2022/10/31 13:38
 * FileName: AppInfoController
 * Description: 应用信息控制层
 */
@Controller
public class AppListController {
    @Resource
    private AppInfoService appInfoService;
    @Resource
    private DictionaryService dictionaryService;
    @Resource
    private AppCategoryService appCategoryService;

    /**
     * 跳转至applist页面的方法
     *
     * @return
     * @throws JsonProcessingException
     */
    @RequestMapping("/backend/toAppList.do")
    public ModelAndView toAppList() throws JsonProcessingException {
        ModelAndView modelAndView = new ModelAndView();

        //查询数据字典
        List<Dictionary> dictionaryList = dictionaryService.queryByTypeCodeDictionaryList("APP_FLATFORM");
        //查询应用分类
        String[] categoryLevel1Arr = {"1", "2",};
        String[] categoryLevel2Arr = {"3", "4", "5", "19", "20", "21", "22", "23", "24", "25", "26", "28", "41", "42", "43",};
        String[] categoryLevel3Arr = {"48", "52", "53", "54", "55", "56", "57", "58", "44", "45", "46", "47", "49", "50", "51", "59", "120", "119", "118", "117", "116", "112", "111", "110", "109", "115", "114", "113", "121", "122", "123",};
        //查询手游分类
        List<AppCategory> categoryLevel1List = appCategoryService.queryAppCategoryListByLevels(categoryLevel1Arr);
        List<AppCategory> categoryLevel2List = appCategoryService.queryAppCategoryListByLevels(categoryLevel2Arr);
        List<AppCategory> categoryLevel3List = appCategoryService.queryAppCategoryListByLevels(categoryLevel3Arr);

        modelAndView.addObject("dictionaryList", dictionaryList);
        modelAndView.addObject("categoryLevel1List", categoryLevel1List);
        modelAndView.addObject("categoryLevel2List", categoryLevel2List);
        modelAndView.addObject("categoryLevel3List", categoryLevel3List);
        // 设置跳转视图
        modelAndView.setViewName("/developer/applist");
        return modelAndView;
    }

    /**
     * 根据分类父级节点id来查询
     */
    @GetMapping("/backend/getAppCategoryLevelList.do")
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
    @PostMapping("/backend/queryAppInfoListConditionForPageAndCount.do")
    @ResponseBody
    public String queryAppInfoListConditionForPageAndCount(@RequestBody Map<String, String> map) {
        System.out.println("map = " + map);
        //查询应用分类
        PageInfo<AppInfo> appInfoPageInfo = appInfoService.queryAppListConditionForPageAndCount(map);
        System.out.println("appInfoPageInfo = " + appInfoPageInfo);
        return JSONUtil.toJsonStr(appInfoPageInfo);
    }
}
