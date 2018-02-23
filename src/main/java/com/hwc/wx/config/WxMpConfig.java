package com.hwc.wx.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

/**
 * 
 * @author Andrew
 *
 */
@Configuration
public class WxMpConfig {
  @Value("#{wxProperties.token}")
  private String token;

  @Value("#{wxProperties.appid}")
  private String appid;

  @Value("#{wxProperties.appsc}")
  private String appsecret;

  @Value("#{wxProperties.aeskey}")
  private String aesKey;

  public String getToken() {
    return this.token;
  }

  public String getAppid() {
    return this.appid;
  }

  public String getAppsecret() {
    return this.appsecret;
  }

  public String getAesKey() {
    return this.aesKey;
  }

}
