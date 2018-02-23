package com.hwc.wx.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.hwc.api.base.RequestBase;
import com.hwc.wx.dto.WxSign;

import me.chanjar.weixin.common.bean.WxJsapiSignature;
import me.chanjar.weixin.common.exception.WxErrorException;
import me.chanjar.weixin.mp.api.WxMpService;
import me.chanjar.weixin.mp.bean.result.WxMpOAuth2AccessToken;
import me.chanjar.weixin.mp.bean.result.WxMpUser;

/**
 * Created by Administrator on 2017/10/30 0030.
 */
@RestController
@RequestMapping("/wechat/data")
public class WxController {
    @Autowired
    private WxMpService  wxService;

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @RequestMapping(value = "/getWxUserData")
    @ResponseBody
    public WxMpUser getWxUserData(@RequestBody RequestBase request) {

        WxMpOAuth2AccessToken accessToken = null;
        WxMpUser wxUser = null;
        try {
            accessToken = this.wxService.oauth2getAccessToken(request.getQuery());
            wxUser = this.wxService.oauth2getUserInfo(accessToken, "zh_CN");
        } catch (Exception e) {
            logger.error("error", e);
        }
        return wxUser;
    }

    @RequestMapping(value = "/testEcho")
    @ResponseBody
    public String testEcho(@RequestBody RequestBase request) {
        return request.getQuery();

    }

    @PostMapping(value = "/WxjSign")
    @ResponseBody
    public WxJsapiSignature WxjSign(@RequestBody WxSign request) {
        WxJsapiSignature response = null;
        try {
            response = wxService.createJsapiSignature(request.getUrl());
        } catch (WxErrorException e) {
            logger.error("error", e);
        }
        return response;
    }

}
