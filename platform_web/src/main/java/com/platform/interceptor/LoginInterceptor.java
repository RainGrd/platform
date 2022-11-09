package com.platform.interceptor;

import com.platform.backend.entity.BackendUser;
import com.platform.constant.CommonsEnum;
import com.platform.developer.entity.DevUser;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Copyright (C), 2017-2022, RainGrd
 * Author: lenovo
 * Date: 2022/11/6 18:15
 * FileName: LoginInterceptor
 * Description:
 */
public class LoginInterceptor implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        HttpSession session = request.getSession();
        BackendUser backendUser = (BackendUser) session.getAttribute(CommonsEnum.SESSION_BACKEND_USER.getValue());
        DevUser devUser = (DevUser) session.getAttribute(CommonsEnum.SESSION_DEVELOPER_USER.getValue());
        if (backendUser != null || devUser != null) {
            return true;
        }
        //重定向403页面
        response.sendRedirect(request.getContextPath() + "/403.jsp");
        return false;
    }
}
