package com.hwc.wx.controller;

import cn.freesoft.FsParameters;
import com.hwc.aliyun.OSSHelper;
import com.hwc.api.base.RequestBase;
import com.hwc.wx.config.AliossConfig;
import me.chanjar.weixin.mp.api.WxMpService;
import me.chanjar.weixin.mp.bean.result.WxMpOAuth2AccessToken;
import me.chanjar.weixin.mp.bean.result.WxMpUser;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

/**
 * Created by Administrator on 2017/10/30 0030.
 */
@RestController
@RequestMapping("/wechat/oss")
public class WxOssController {
    @Autowired
    private WxMpService wxService;
    @Autowired
    private AliossConfig aliossConfig;

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @RequestMapping(value = "/getWxUserData")
    @ResponseBody
    public WxMpUser getWxUserData(@RequestBody RequestBase request) {

        WxMpOAuth2AccessToken accessToken = null;
        WxMpUser wxUser=null;
        try {
            accessToken = this.wxService.oauth2getAccessToken(request.getQuery());
            wxUser = this.wxService.oauth2getUserInfo(accessToken, "zh_CN");
        } catch (Exception e) {
            logger.error("error",e);
        }
        return wxUser;
    }


    @RequestMapping(value = "/getPostPolicy",method = RequestMethod.GET)
    @ResponseBody
    public Map<String,String> testEcho(@RequestParam(name = "key", required = false) String key,@RequestParam(name = "exp", required = false) String exp) {
        FsParameters input = new FsParameters();
        if(key!=null&&!key.isEmpty()){
            input.set(OSSHelper.KEY_FOLDER, key);
        }
        if(exp!=null){
            input.set(OSSHelper.KEY_EXPIRETIME, exp);
        }
        input.set(OSSHelper.KEY_ACCESSKEYID, aliossConfig.getAccesskeyid());
        input.set(OSSHelper.KEY_ACCESSKEYSECRET, aliossConfig.getAccesskeysecret());
        input.set(OSSHelper.KEY_ENDPOINT, aliossConfig.getEndpoint());
        input.set(OSSHelper.KEY_BUCKETNAME, aliossConfig.getBucketname());
        Map<String,String>  resMap= OSSHelper.getPostPolicy(input);
        if(resMap!=null){
            resMap.put("host",aliossConfig.getHosturl());
        }
        return resMap;
    }


}

