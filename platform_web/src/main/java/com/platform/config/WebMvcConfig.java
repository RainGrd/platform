package com.platform.config;

import com.platform.interceptor.LoginInterceptor;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.util.ArrayList;
import java.util.List;

/**
 * Copyright (C), 2017-2022, RainGrd
 * Author: lenovo
 * Date: 2022/11/6 18:23
 * FileName: WebMvcConfig
 * Description: MVCConfig配置
 */
//@Configuration
public class WebMvcConfig implements WebMvcConfigurer {

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
// 定义放行路径
        List<String> excludePathPatterns = new ArrayList<>();
        excludePathPatterns.add("/webapp/index.jsp");
        excludePathPatterns.add("/js/**");
        excludePathPatterns.add("/statics/**");
        excludePathPatterns.add("/uploadfiles/**");
        // 定义拦截路径
        List<String> addPathPatterns = new ArrayList<>();
        registry.addInterceptor(new LoginInterceptor()).addPathPatterns(addPathPatterns).excludePathPatterns(excludePathPatterns);
    }
}
