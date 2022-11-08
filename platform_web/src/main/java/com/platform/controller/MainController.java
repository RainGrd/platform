package com.platform.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Copyright (C), 2017-2022, RainGrd
 * Author: lenovo
 * Date: 2022/10/29 9:54
 * FileName: MainController
 * Description:
 */
@Controller
public class MainController {


    /**
     * backend管理系统登录页面
     */
    @RequestMapping("/backend/backendLogin.do")
    public String backendLogin() {
        return "backend/backendLogin";
    }

    /**
     *
     */
    @RequestMapping("/developer/developerLogin.do")
    public String developerLogin() {
        return "developer/devlogin";
    }

}
