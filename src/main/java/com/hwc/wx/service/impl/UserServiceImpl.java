/**
 * Copyright (c) 2018 All Rights Reserved.
 */
package com.hwc.wx.service.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.alibaba.fastjson.JSONObject;
import com.hwc.wx.base.BaseBizContants;
import com.hwc.wx.base.ServiceUrlConstants;
import com.hwc.wx.dto.UserContext;
import com.hwc.wx.service.UserService;
import com.hwc.wx.utils.HttpClient;
import com.hwc.wx.utils.StringUtil;

/**
 * 
 * @author jinlilong
 * @version $Id: UserServiceImpl.java, v 0.1 2018年1月23日 下午8:06:56 jinlilong Exp $
 */
@Service
public class UserServiceImpl implements UserService {

    /**  */
    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    /** 
     * @see com.hwc.wx.service.UserService#getUserContext(java.lang.String)
     */
    @Override
    public UserContext getUserContext(String openId) {
        UserContext userContext = null;
        try {
            JSONObject requestjson = new JSONObject();
            requestjson.put("openId", openId);
            String resData = HttpClient.getResultWithHeader(
                ServiceUrlConstants.QUERY_USER_CONTEXT_DATA, requestjson, null);
            if (!StringUtil.isEmpty(resData)) {
                JSONObject response = JSONObject.parseObject(resData);
                Object obj = response.get(BaseBizContants.RESPONSE_STATE_KEY);
                if (obj != null && Boolean.valueOf(obj.toString())) {
                    userContext = JSONObject.parseObject(
                        response.getString(BaseBizContants.RESPONSE_DATA_KEY), UserContext.class);
                }
            }
        } catch (Exception e) {
            logger.error("查询用户基础信息异常", e);
        }

        return userContext;
    }

}
