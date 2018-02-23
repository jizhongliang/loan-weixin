/**
 * Copyright (c) 2018 All Rights Reserved.
 */
package com.hwc.wx.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * 
 * @author jinlilong
 * @version $Id: ApiBaseConfig.java, v 0.1 2018年1月24日 上午11:15:03 jinlilong Exp $
 */
@Component
public class ApiBaseConfig {

    /**  ip*/
    public static String serverUrl;

    /**
     * Setter method for property <tt>serverUrl</tt>.
     * 
     * @param serverUrl value to be assigned to property serverUrl
     */
    @Value("#{baseConfigProperties.serverUrl}")
    public void setServerUrl(String serverUrl) {
        ApiBaseConfig.serverUrl = serverUrl;
    }

}
