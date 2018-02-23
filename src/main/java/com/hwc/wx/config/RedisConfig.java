/**
 * Copyright (c) 2018 All Rights Reserved.
 */
package com.hwc.wx.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * 
 * @author jinlilong
 * @version $Id: RedisConfigs.java, v 0.1 2018年1月19日 下午11:01:52 jinlilong Exp $
 */
@Component
public class RedisConfig {

    /**  ip*/
    public static String host;

    /**  端口*/
    public static String port;

    /**  密码*/
    public static String password;

    /**  */
    public static String database;

    /**
     * Setter method for property <tt>host</tt>.
     * 
     * @param host value to be assigned to property host
     */

    @Value("#{redisProperties.host}")
    public void setHost(String host) {
        RedisConfig.host = host;
    }

    /**
     * Setter method for property <tt>port</tt>.
     * 
     * @param port value to be assigned to property port
     */
    @Value("#{redisProperties.port}")
    public void setPort(String port) {
        RedisConfig.port = port;
    }

    /**
     * Setter method for property <tt>password</tt>.
     * 
     * @param password value to be assigned to property password
     */
    @Value("#{redisProperties.password}")
    public void setPassword(String password) {
        RedisConfig.password = password;
    }

    /**
     * Setter method for property <tt>database</tt>.
     * 
     * @param database value to be assigned to property database
     */
    @Value("#{redisProperties.database}")
    public void setDatabase(String database) {
        RedisConfig.database = database;
    }

}
