/**
 * Copyright (c) 2018 All Rights Reserved.
 */
package com.hwc.wx.service;

import com.hwc.wx.dto.UserContext;

/**
 * 
 * @author jinlilong
 * @version $Id: UserService.java, v 0.1 2018年1月23日 下午8:03:26 jinlilong Exp $
 */
public interface UserService {

    /**
     * 根据openId获取用户的上下文
     * @param openId
     * @return
     */
    public UserContext getUserContext(String openId);

}
