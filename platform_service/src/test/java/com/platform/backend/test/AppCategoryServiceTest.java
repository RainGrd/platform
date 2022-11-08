package com.platform.backend.test;

import cn.hutool.core.io.file.FileWriter;
import cn.hutool.json.JSON;
import cn.hutool.json.JSONArray;
import cn.hutool.json.JSONObject;
import cn.hutool.json.JSONUtil;
import com.platform.backend.entity.AppCategory;
import com.platform.backend.service.AppCategoryService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;
import java.io.File;
import java.nio.charset.Charset;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Copyright (C), 2017-2022, RainGrd
 * Author: lenovo
 * Date: 2022/10/31 15:22
 * FileName: AppCategoryServiceTest
 * Description:
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:applicationContext-dao.xml", "classpath:applicationContext-service.xml"})
public class AppCategoryServiceTest {

    @Resource
    private AppCategoryService appCategoryService;

    @Test
    public void queryAppCategoryListByLevelsTest() {
        String[] categoryLevel1Arr = {"1", "2", "3", "4", "5"};
        String[] categoryLevel2Arr = {"19", "20", "21", "22", "23", "24", "25", "26", "28", "41", "42", "43",};
        String[] categoryLevel3Arr = {"48", "52", "53", "54", "55", "56", "57", "58", "44", "45", "46", "47", "49", "50", "51", "59", "120", "119", "118", "117", "116", "112", "111", "110", "109", "115", "114", "113", "121", "122", "123",};
        List<AppCategory> categoryLevel1List = appCategoryService.queryAppCategoryListByLevels(categoryLevel1Arr);
        System.out.println("categoryLevel1List = " + categoryLevel1List);
        List<AppCategory> categoryLevel2List = appCategoryService.queryAppCategoryListByLevels(categoryLevel2Arr);
        System.out.println("categoryLevel2List = " + categoryLevel2List);
        List<AppCategory> categoryLevel3List = appCategoryService.queryAppCategoryListByLevels(categoryLevel3Arr);
        System.out.println("categoryLevel3List = " + categoryLevel3List);
      /*  JSONObject jsonObject = new JSONObject();
        JSONArray jsonArray = new JSONArray();
        stringObjectMap.put("1",appCategories);
        stringObjectMap.put("2",appCategories);
        jsonObject.set("pid", stringObjectMap);

//        System.out.println(appCategories);
        fileWriter.write(JSONUtil.toJsonStr(jsonObject));
        System.out.println("==============================");
        JSONObject jsonObject1 = JSONUtil.readJSONObject(
                new File("D:\\materials\\BeyondPlatform\\platform\\platform_web\\src\\main\\webapp\\statics\\json\\categorylevellist.json"),
                Charset.defaultCharset());
        Object pid = jsonObject1.get("pid");
        System.out.println("pid = " + pid);
        System.out.println(JSONUtil.readJSONObject(
                new File("D:\\materials\\BeyondPlatform\\platform\\platform_web\\src\\main\\webapp\\statics\\json\\categorylevellist.json"),
                Charset.defaultCharset()));*/

    }

    @Test
    public void queryAppCategoryListByParentIdTest() {
        System.out.println(appCategoryService.queryAppCategoryListByParentId(3L));
    }

    @Test
    public void writerJson() {
        String[] arr = new String[]{"1", "2"};
        List<AppCategory> appCategories = appCategoryService.queryAppCategoryListByLevels(arr);
        Map<String, Object> stringObjectMap = new HashMap<>();
        File file = new File("D:\\materials\\BeyondPlatform\\platform\\platform_web\\src\\main\\webapp\\statics\\json\\categorylevellist.json");
        FileWriter fileWriter = new FileWriter(file);
        JSONObject jsonObject = new JSONObject();
        jsonObject.set("pid:1", appCategories);
        jsonObject.set("pid:2", appCategories);
        fileWriter.write(JSONUtil.toJsonStr(jsonObject));
        System.out.println("=========================");
        JSONObject jsonObject1 = JSONUtil.readJSONObject(file, Charset.defaultCharset());
        System.out.println(jsonObject.get("pid:1"));
    }
}
