/**
 * Copyright (c) 2018 All Rights Reserved.
 */
package com.hwc.wx.controller;

import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.alibaba.fastjson.JSONObject;
import com.hwc.wx.base.BaseBizContants;
import com.hwc.wx.base.BaseResponse;
import com.hwc.wx.dto.UserContext;
import com.hwc.wx.service.UserService;
import com.hwc.wx.utils.HttpClient;
import com.hwc.wx.utils.JedisUtil;
import com.hwc.wx.utils.StringUtil;

/**
 * 
 * @author jinlilong
 * @version $Id: BaseController.java, v 0.1 2018年1月19日 下午4:40:04 jinlilong Exp $
 */
public class BaseController {

    /**  */
    @Autowired
    private UserService  userService;

    /**  */
    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    /**
     * 
     * @param request
     * @param map
     * @param callback
     * @return
     */
    public void httpExecute(String openId, HttpServletResponse response,
                            ControllerCallback callback) {

        String restData = null;
        try {
            UserContext context = getUserContext(openId);
            restData = callback.execute(context);
            restData = handleSuccessMap(restData);
        } catch (Exception e) {
            restData = JSONObject.toJSONString(BaseResponse.getFailResponse());
            logger.error("系统发生异常", e);
        } finally {
            HttpClient.writeJson(response, restData);
        }

    }

    /**
     * 
     * @param map
     */
    public String handleSuccessMap(String restData) {
        if (StringUtil.isEmpty(restData)) {
            logger.error("restData is null");

        }
        logger.info("restData=>" + restData);
        JSONObject json = JSONObject.parseObject(restData);
        if (json.containsKey(BaseBizContants.RESPONSE_STATE_KEY)) {
            Object state = json.get(BaseBizContants.RESPONSE_STATE_KEY);
            if (state == null) {
                return JSONObject.toJSONString(BaseResponse.getFailResponse());
            } else {
                return restData;
            }
        }
        return JSONObject.toJSONString(BaseResponse.getFailResponse());

    }

    /**
     * 
     * @param openId
     * @return
     */
    public UserContext getUserContext(String openId) {
        if (StringUtil.isEmpty(openId)) {
            return new UserContext();
        }
        JedisUtil jedisUtil = JedisUtil.getInstance();
        JedisUtil.Strings strings = jedisUtil.new Strings();
        String data = strings.get(openId);
        if (StringUtil.isEmpty(data)) {
            return initUserContext(openId);
        }
        try {
            UserContext userContext = JSONObject.parseObject(data, UserContext.class);
            if (userContext.getUserId() == 0) {
                return initUserContext(openId);
            } else {
                return userContext;
            }
        } catch (Exception e) {
            logger.error("获取用户上下文json转换失败", e);
        }
        return null;
    }

    /**
     * 初始化上下文
     */
    public UserContext initUserContext(String openId) {
        UserContext userContext = userService.getUserContext(openId);
        if (userContext != null) {
            JedisUtil jedisUtil = JedisUtil.getInstance();
            JedisUtil.Strings strings = jedisUtil.new Strings();
            strings.set(openId, JSONObject.toJSONString(userContext));
        } else {
            userContext = new UserContext();
        }
        return userContext;
    }

    /**
     * 
     * @author jinlilong
     * @version $Id: BaseController.java, v 0.1 2018年1月23日 下午8:17:30 jinlilong Exp $
     */
    public abstract class ControllerCallback {

        public abstract String execute(UserContext context) throws Exception;

    }
}
