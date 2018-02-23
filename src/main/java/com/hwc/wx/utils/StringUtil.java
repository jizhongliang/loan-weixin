/**
 * Copyright (c) 2018 All Rights Reserved.
 */
package com.hwc.wx.utils;

import java.util.HashMap;
import java.util.Map;

/**
 * 
 * @author jinlilong
 * @version $Id: StringUtil.java, v 0.1 2018年1月19日 下午4:21:13 jinlilong Exp $
 */
public class StringUtil {

    /**
     * 返回获取session失败时 的默认错误信息
     * @return
     */
    public static Map<String, Object> getSessionFailResponse() {
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("message", "登录过期,请重新登录");
        map.put("success", false);
        map.put("code", "SESSION_OUT_TIME");
        return map;
    }

    public static boolean isEmpty(String str) {
        if (str == null || str.equals("")) {
            return true;
        }
        return false;
    }
}
