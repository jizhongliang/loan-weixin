package com.hwc.wx.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

/**
 * Created by Administrator on 2017/11/22 0022.
 */
@Configuration
public class AliossConfig {


    @Value("#{ossProperties.accesskeyid}")
    private String accesskeyid;

    @Value("#{ossProperties.accesskeysecret}")
    private String accesskeysecret;

    @Value("#{ossProperties.endpoint}")
    private String endpoint;

    @Value("#{ossProperties.bucketname}")
    private String bucketname;


    @Value("#{ossProperties.hosturl}")
    private String hosturl;

    public String getHosturl() {
        return hosturl;
    }

    public String getAccesskeyid() {
        return accesskeyid;
    }

    public String getAccesskeysecret() {
        return accesskeysecret;
    }

    public String getEndpoint() {
        return endpoint;
    }

    public String getBucketname() {
        return bucketname;
    }


}
