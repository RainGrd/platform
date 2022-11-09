package com.platform.constant;

/**
 * Copyright (C), 2017-2022, RainGrd
 * Author: lenovo
 * Date: 2022/10/29 19:05
 * FileName: CommonsEnum
 * Description: 公共的常量类
 */
public enum CommonsEnum {
    YMD("yyyy-MM-dd"),
    YMD_HMS("yyyy-MM-dd HH:mm:ss"),
    HMS("HH:mm:ss"),
    /**
     * 成功
     */
    RESULT_CODE_SUCCESS("1"),
    /**
     * 失败
     */
    RESULT_CODE_FAIL("0"),
    SESSION_BACKEND_USER("userSession"),
    SESSION_DEVELOPER_USER("devUserSession");

    /**
     *
     */
    private String value;

    CommonsEnum(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
