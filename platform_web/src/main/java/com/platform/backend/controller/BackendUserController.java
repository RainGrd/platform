package com.platform.backend.controller;

import com.platform.Vo.Result;
import com.platform.backend.entity.BackendUser;
import com.platform.backend.entity.Dictionary;
import com.platform.backend.service.BackendUserService;
import com.platform.backend.service.DictionaryService;
import com.platform.constant.CommonsEnum;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
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
public class BackendUserController {
    @Resource
    private BackendUserService backendUserService;
    @Resource
    private DictionaryService dictionaryService;

    /**
     * 用户登录方法
     *
     * @param backendUser 管理员员工对象
     * @return
     */
    @PostMapping("/backend/login.do")
    @ResponseBody
    public Object login(@RequestBody BackendUser backendUser, HttpSession session) {
        BackendUser user = backendUserService.login(backendUser.getUserCode(), backendUser.getUserPassword());
        System.out.println("user = " + user);
        //若查询出来用户为空
        if (user == null) {
            // 返回错误信息
            return Result.fail("用户名或密码错误");
        }
        // 不为空的话 存放在会话对象中
        session.setAttribute(CommonsEnum.SESSION_BACKEND_USER.getValue(), user);
        // 返回响应信息
        return Result.ok();
    }

    /**
     * 退出登录方法
     *
     * @param session
     */
    @RequestMapping("/backend/loginOut.do")
    public String loginOut(HttpSession session) {
        //清空session对象
        session.invalidate();
        // 跳转至管理登录页面
        return "/backend/backendLogin";
    }

    /**
     * 跳转后台管理系统主页
     */
    @RequestMapping("/backend/backendIndex.do")
    public ModelAndView backendIndex(HttpSession session) {
        ModelAndView modelAndView = new ModelAndView();
        /*查询存放当前云端的管理员对象*/
        BackendUser backendUser = (BackendUser) session.getAttribute(CommonsEnum.SESSION_BACKEND_USER.getValue());
        // 根据存放当前云端的管理员对象的类型去查询此用户的角色
        Dictionary dictionary = dictionaryService.queryByValueId(backendUser.getUserType());
        modelAndView.addObject("dictionary", dictionary);
        modelAndView.setViewName("backend/main");
        return modelAndView;
    }

    /**
     * 跳转至403页面
     *
     * @return
     */
    @RequestMapping("/backend/toFZT.do")
    public String toFZT() {
        return "/WEB-INF/403.jsp";
    }

}
