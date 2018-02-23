package com.hwc.wx.handler;

import java.util.Map;

import org.springframework.stereotype.Component;

import com.alibaba.fastjson.JSONObject;
import com.hwc.wx.base.ServiceUrlConstants;
import com.hwc.wx.builder.TextBuilder;
import com.hwc.wx.config.ApiBaseConfig;
import com.hwc.wx.service.WeixinService;
import com.hwc.wx.utils.HttpClient;

import me.chanjar.weixin.common.exception.WxErrorException;
import me.chanjar.weixin.common.session.WxSessionManager;
import me.chanjar.weixin.mp.api.WxMpService;
import me.chanjar.weixin.mp.bean.message.WxMpXmlMessage;
import me.chanjar.weixin.mp.bean.message.WxMpXmlOutMessage;
import me.chanjar.weixin.mp.bean.result.WxMpUser;

/**
 * 
 * @author Andrew
 *
 */
@Component
public class SubscribeHandler extends AbstractHandler {

    @Override
    public WxMpXmlOutMessage handle(WxMpXmlMessage wxMessage, Map<String, Object> context,
                                    WxMpService wxMpService,
                                    WxSessionManager sessionManager) throws WxErrorException {

        this.logger.info("新关注用户 OPENID: " + wxMessage.getFromUser());

        WeixinService weixinService = (WeixinService) wxMpService;

        // 获取微信用户基本信息
        WxMpUser userWxInfo = weixinService.getUserService().userInfo(wxMessage.getFromUser(),
            null);

        if (userWxInfo != null) {
            // TODO 可以添加关注用户到本地

            try {
                String resData = "";
                JSONObject requestjson = new JSONObject();
                requestjson.put("phoneMark", wxMessage.getFromUser());
                requestjson.put("versionCode", "wx");
                requestjson.put("versionName", "1.0");
                resData = HttpClient.getResult(ApiBaseConfig.serverUrl,
                    ServiceUrlConstants.EQREGISTER, requestjson);
                JSONObject resp = JSONObject.parseObject(resData);
                if (!resp.getBoolean("success")) {
                    logger.error("error", resp);
                }
            } catch (Exception e) {
                logger.error("error", e);
            }
        }

        WxMpXmlOutMessage responseResult = null;
        try {
            responseResult = handleSpecial(wxMessage);
        } catch (Exception e) {
            this.logger.error(e.getMessage(), e);
        }

        if (responseResult != null) {
            return responseResult;
        }

        try {
            return new TextBuilder().build("感谢关注", wxMessage, weixinService);
        } catch (Exception e) {
            this.logger.error(e.getMessage(), e);
        }

        return null;
    }

    /**
     * 处理特殊请求，比如如果是扫码进来的，可以做相应处理
     */
    protected WxMpXmlOutMessage handleSpecial(WxMpXmlMessage wxMessage) throws Exception {
        //TODO
        return null;
    }

}
