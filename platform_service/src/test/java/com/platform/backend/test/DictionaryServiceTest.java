package com.platform.backend.test;

import com.platform.backend.entity.Dictionary;
import com.platform.backend.service.DictionaryService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

/**
 * Copyright (C), 2017-2022, RainGrd
 * Author: lenovo
 * Date: 2022/10/31 9:13
 * FileName: DictionaryServiceTest
 * Description:
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:applicationContext-dao.xml", "classpath:applicationContext-service.xml"})
public class DictionaryServiceTest {

    @Autowired
    private DictionaryService dictionaryService;


    @Test
    public void testGetId() {
        Dictionary dictionary = dictionaryService.queryByValueId(1L);
        System.out.println("dictionary = " + dictionary);
    }

    @Test
    public void queryByTypeCodeDictionaryListTest() {
        System.out.println(dictionaryService.queryByTypeCodeDictionaryList("APP_FLATFORM"));
        List<Dictionary> statusList = dictionaryService.queryByTypeCodeDictionaryList("APP_STATUS");
        System.out.println("statusList = " + statusList);
        String str = "段荣贵";
        char[] chars = str.toCharArray();
        for (int i = chars.length-1; i >=0; i--) {
            System.out.println(chars[i]);
            System.out.println(str.charAt(i));
        }
    }
}
