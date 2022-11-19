package com.platform.util;

import javax.servlet.http.HttpServletRequest;

/**
 * Copyright (C), 2017-2022, RainGrd
 * Author: lenovo
 * Date: 2022/11/8 9:33
 * FileName: CommonUtil
 * Description:
 */
public class CommonUtil {

    /**
     * 设置文件绝对路径
     *
     * @param request
     * @return
     */
    public static String setFileAbsPath(HttpServletRequest request) {
        String realPath = request.getSession().getServletContext().getRealPath("/");
        System.out.println("realPath = " + realPath);
        System.out.println(request.getServletContext().getRealPath("\\target"));
        return realPath.substring(0, realPath.lastIndexOf("\\target")) + "\\src\\main\\webapp\\";
    }

    public static String strReplace(String str) {
        return str.replace("/", "\\");
    }


}
