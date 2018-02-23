package com.hwc.wx.utils;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.alibaba.fastjson.JSON;
import com.hwc.bs.core.HwcHttpClient2;
import com.hwc.wx.config.ApiBaseConfig;

import cn.freesoft.utils.FsUtils;

/**
 * 外网服务器访问配置类
 */
public class HttpClient {

    public static final int       TIME_OUT  = 900000;

    private static Logger         logger    = LoggerFactory.getLogger(HttpClient.class);

    // 常量对象
    private static HttpClient     hwcClient = null;

    private static HwcHttpClient2 HWC_HTTP  = new HwcHttpClient2();

    /**
     * 访问外网服务器
     *
     * @param rootpath 外网服务器完整项目名
     * @param path     外网服务器映射访问路径
     * @param timeout  外网服务器访问超时时间
     * @param json     传递至服务器的json参数
     * @return json字符串
     * @throws Exception
     */
    public static String getResult(String rootpath, String path, int timeout,
                                   String json) throws Exception {
        String result = "";

        if (FsUtils.strsEmpty(timeout)) {
            timeout = TIME_OUT;
        }
        try {
            logger.info("发送: [{}] {}", path, json);
            Map<String, String> header = new HashMap<String, String>();
            result = HWC_HTTP.requestjson(rootpath, timeout, path, json, header);
            logger.info("接收: {}", result);
        } catch (Exception e) {
            logger.error("调用异常", e);
        }
        return result;
    }

    public static String getResultByGET(String rootpath, String path,
                                        String json) throws Exception {
        String result = "";
        try {
            logger.info("发送: [{}] {}", path, json);
            result = HWC_HTTP.requestgetWithHeader(rootpath, TIME_OUT, path, json, null);
            logger.info("接收: {}", result);
        } catch (Exception e) {
            logger.error("调用异常", e);
        }
        return result;
    }

    public static String getResult(String rootpath, String path, Object object) throws Exception {
        String json = object instanceof String ? (String) object : JSON.toJSONString(object);
        return getResult(rootpath, path, TIME_OUT, json);
    }

    public static String getResultWithHeader(String rootpath, String path, Object object,
                                             String headert) throws Exception {
        String json = object instanceof String ? (String) object : JSON.toJSONString(object);
        String result = "";
        String tokeStr = "no token";
        try {
            Map<String, String> header = new HashMap<String, String>();
            if (!FsUtils.strsEmpty(headert)) {
                tokeStr = "have token";
                header.put("Authorization", "Bearer " + headert);
            }
            logger.info("发送: [{}] {} {}", path, tokeStr, json);
            result = HWC_HTTP.requestjson(rootpath, TIME_OUT, path, json, header);
            logger.info("接收: {} {}", tokeStr, result);
        } catch (Exception e) {
            logger.error("调用异常", e);
        }
        return result;
    }

    /**
     * 
     * @param path
     * @param object
     * @param headert
     * @return
     * @throws Exception
     */
    public static String getResultWithHeader(String path, Object object,
                                             String headert) throws Exception {
        String json = object instanceof String ? (String) object : JSON.toJSONString(object);
        String result = "";
        String tokeStr = "no token";
        try {
            Map<String, String> header = new HashMap<String, String>();
            if (!FsUtils.strsEmpty(headert)) {
                tokeStr = "have token";
                header.put("Authorization", "Bearer " + headert);
            }
            logger.info("发送: [{}] {} {}", path, tokeStr, json);
            result = HWC_HTTP.requestjson(ApiBaseConfig.serverUrl, TIME_OUT, path, json, header);
            logger.info("接收: {} {}", tokeStr, result);
        } catch (Exception e) {
            logger.error("调用异常", e);
        }
        return result;
    }

    /**
     * 
     * @param path
     * @param object
     * @param headers
     * @return
     * @throws Exception
     */
    public static String getResultWithHeaders(String path, Object object,
                                              Map<String, String> headers) throws Exception {
        String json = object instanceof String ? (String) object : JSON.toJSONString(object);
        String result = "";
        //      String tokeStr="";
        //      StringBuffer sb=new StringBuffer();
        //      for (Map.Entry<String,String> header : headers.entrySet()){
        ////            System.out.println();
        //          sb.append("key:"+header.getKey()+";value:"+header.getValue());
        //      }
        try {
            logger.info("发送: [{}] *[{}]* {}", path, JSON.toJSONString(headers), json);
            result = HWC_HTTP.requestjson(ApiBaseConfig.serverUrl, TIME_OUT, path, json, headers);
            logger.info("接收: {} {}", JSON.toJSONString(headers), result);
        } catch (Exception e) {
            logger.error("调用异常", e);
        }
        return result;
    }

    public static String getResultWithHeaders(String rootpath, String path, Object object,
                                              Map<String, String> headers) throws Exception {
        String json = object instanceof String ? (String) object : JSON.toJSONString(object);
        String result = "";
        //		String tokeStr="";
        //		StringBuffer sb=new StringBuffer();
        //		for (Map.Entry<String,String> header : headers.entrySet()){
        ////			System.out.println();
        //			sb.append("key:"+header.getKey()+";value:"+header.getValue());
        //		}
        try {
            logger.info("发送: [{}] *[{}]* {}", path, JSON.toJSONString(headers), json);
            result = HWC_HTTP.requestjson(rootpath, TIME_OUT, path, json, headers);
            logger.info("接收: {} {}", JSON.toJSONString(headers), result);
        } catch (Exception e) {
            logger.error("调用异常", e);
        }
        return result;
    }

    public static <T> T getResultObject(String rootpath, String path, int timeout,
                                        Object object) throws Exception {
        Object result = null;
        String req = object instanceof String ? (String) object : JSON.toJSONString(object);
        String resp = getResult(rootpath, path, timeout, req);
        result = JSON.parseObject(resp);

        return (T) result;
    }

    public static <T> T getResultObject(String rootpath, String path,
                                        Object object) throws Exception {
        return (T) getResultObject(rootpath, path, TIME_OUT, object);
    }

    @SuppressWarnings("static-access")
    public static void writeJson(HttpServletResponse response, String jsonData) {
        HWC_HTTP.writeJson(response, jsonData);
    }

}
