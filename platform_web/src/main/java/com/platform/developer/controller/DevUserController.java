package com.platform.developer.controller;

import com.platform.Vo.Result;
import com.platform.backend.service.DictionaryService;
import com.platform.constant.CommonsEnum;
import com.platform.developer.entity.DevUser;
import com.platform.developer.service.DevUserService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

/**
 * Copyright (C), 2017-2022, RainGrd
 * Author: lenovo
 * Date: 2022/10/29 16:49
 * FileName: BackendController
 * Description: 管理员用户控制层
 */
@Controller
public class DevUserController {
    @Resource
    private DevUserService devUserService;
    @Resource
    private DictionaryService dictionaryService;

    /**
     * 用户登录方法
     *
     * @param devUser 开发者对象
     * @return
     */
    @PostMapping("/developer/devLogin.do")
    @ResponseBody
    public Object devLogin(@RequestBody DevUser devUser, HttpSession session) {
        DevUser user = devUserService.devLogin(devUser.getDevCode(), devUser.getDevPassword());
        System.out.println("user = " + user);
        //若查询出来用户为空
        if (user == null) {
            // 返回错误信息
            return Result.fail("用户名或密码错误");
        }
        // 不为空的话 存放在会话对象中
        session.setAttribute(CommonsEnum.SESSION_DEVELOPER_USER.getValue(), user);
        // 返回响应信息
        return Result.ok();
    }

    /**
     * 退出登录方法
     *
     * @param session
     */
    @RequestMapping("/developer/devLoginOut.do")
    public String devLoginOut(HttpSession session) {
        //清空session对象
        session.invalidate();
        // 跳转至开发者登录页面
        return "/developer/devlogin";
    }

    /**
     * 跳转后台管理系统主页
     */
    @RequestMapping("/developer/devIndex.do")
    public ModelAndView devIndex(HttpSession session) {
        ModelAndView modelAndView = new ModelAndView();
        //查询存放当前云端的管理员对象
        DevUser devUser = (DevUser) session.getAttribute(CommonsEnum.SESSION_DEVELOPER_USER.getValue());
        // 根据存放当前云端的管理员对象的类型去查询此用户的角色
        modelAndView.setViewName("developer/main");
        return modelAndView;
    }

}
