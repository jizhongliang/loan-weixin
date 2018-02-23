/**
 * Copyright (c) 2018 All Rights Reserved.
 */
package com.hwc.wx.utils;

import java.util.HashMap;
import java.util.Map;

import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.alibaba.fastjson.JSON;

/**
 * 
 * @author jinlilong
 * @version $Id: HttpClientUtil.java, v 0.1 2018年1月22日 上午10:20:59 jinlilong Exp $
 */
public class HttpClientUtil {

    /**  */
    private static Logger logger = LoggerFactory.getLogger(HttpClientUtil.class);

    public static String send(String rootpath, String path, Object object, String headert) {

        String json = object instanceof String ? (String) object : JSON.toJSONString(object);

        String tokeStr = "no token";
        //创建httpclient对象  
        CloseableHttpClient client = HttpClients.createDefault();
        //创建post方式请求对象  
        String url = rootpath + path;
        HttpPost httpPost = new HttpPost(url);

        //装填参数  
        Map<String, String> header = new HashMap<String, String>();
        if (!StringUtil.isEmpty(headert)) {
            tokeStr = "have token";
            header.put("Authorization", "Bearer " + headert);
        }
        logger.info("发送: [{}] {} {}", path, tokeStr, json);

        //指定报文头【Content-type】、【User-Agent】  
        httpPost.setHeader("Content-type", "application/x-www-form-urlencoded");
        httpPost.setHeader("User-Agent", "Mozilla/4.0 (compatible; MSIE 5.0; Windows NT; DigExt)");

        /*httpPost.setEntity(new UrlEncodedFormEntity(nvps, encoding));*/

        /* System.out.println("请求地址：" + url);
        System.out.println("请求参数：" + nvps.toString());*/
        return "";
    }

}
