package com.platform.Vo;

import com.platform.constant.CommonsEnum;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Copyright (C), 2017-2022, RainGrd
 * Author: lenovo
 * Date: 2022/10/29 19:00
 * FileName: Result
 * Description: 响应结果类
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Result {
    /**
     * 响应编码 1:成功 0:失败
     */
    private Integer code;
    /**
     * 响应数据
     */
    private Object data;
    /**
     * 提示信息
     */
    private String message;

    /**
     * @return
     * @descript 返回成功，只响应编码
     */
    public static Result ok() {
        return new Result(Integer.parseInt(CommonsEnum.RESULT_CODE_SUCCESS.getValue()), null, null);
    }

    /**
     * @param data
     * @return
     * @descript 返回成功，只响应编码和数据
     */
    public static Result ok(Object data) {
        return new Result(Integer.parseInt(CommonsEnum.RESULT_CODE_SUCCESS.getValue()), data, null);
    }

    /**
     * @param msg
     * @return
     * @descript 返回成功，只响应编码和提示信息
     */
    public static Result ok(String msg) {
        return new Result(Integer.parseInt(CommonsEnum.RESULT_CODE_SUCCESS.getValue()), null, msg);
    }

    /**
     * @param msg
     * @return
     * @descript 返回失败，只响应编码和提示信息
     */
    public static Result fail(String msg) {
        return new Result(Integer.parseInt(CommonsEnum.RESULT_CODE_FAIL.getValue()), null, msg);
    }
}
