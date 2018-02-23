package com.hwc.wx.controller;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.alibaba.fastjson.JSONObject;
import com.hwc.api.base.RequestBase;
import com.hwc.wx.base.ServiceUrlConstants;
import com.hwc.wx.dto.UserContext;
import com.hwc.wx.utils.HttpClient;
import com.hwc.wx.utils.StringUtil;

import cn.freesoft.utils.FsUtils;
import me.chanjar.weixin.mp.api.WxMpService;
import me.chanjar.weixin.mp.bean.result.WxMpOAuth2AccessToken;
import me.chanjar.weixin.mp.bean.result.WxMpUser;

/**
 * 
 * @author jinlilong
 * @version $Id: UserController.java, v 0.1 2018年1月25日 上午10:17:48 jinlilong Exp $
 */
@RestController
@RequestMapping("/wechat/user/api")
public class UserController extends BaseController {

    /**  */
    @Autowired
    private WxMpService  wxService;

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    /**
     * 
     * @param request
     * @param headertoken
     * @param requests
     * @return
     */
    @PostMapping(value = "/checkWxUser")
    @ResponseBody
    public JSONObject checkWxUser(@RequestBody RequestBase request,
                                  @RequestHeader(name = "at", required = false) String headertoken,
                                  HttpServletRequest requests) {
        JSONObject object = null;
        WxMpOAuth2AccessToken accessToken = null;
        WxMpUser wxUser = null;
        try {
            accessToken = this.wxService.oauth2getAccessToken(request.getQuery());
            wxUser = this.wxService.oauth2getUserInfo(accessToken, "zh_CN");
            JSONObject req = new JSONObject();
            req.put("openid", wxUser.getOpenId());
            if (wxUser.getUnionId() != null) {
                req.put("unionId", wxUser.getUnionId());
            }
            String resData = HttpClient.getResultWithHeader(ServiceUrlConstants.WX_LOGIN, req,
                headertoken);
            JSONObject resp = JSONObject.parseObject(resData);
            if (StringUtil.isEmpty(resData)) {
                logger.info("/checkWxUser,resData is null!");
            }
            object = new JSONObject();
            object.put("wxdata", wxUser);
            object.put("login", resp);
        } catch (Exception e) {
            logger.error("error", e);
        }
        return object;
    }

    /**
     * 
     * @param requestjson
     * @param openId
     * @param request
     * @param response
     */
    @PostMapping(value = "/wxLogin")
    public void wxLogin(@RequestBody JSONObject requestjson,
                        @RequestHeader(name = "openId", required = false) String openId,
                        HttpServletRequest request, HttpServletResponse response) {
        this.httpExecute(openId, response, new ControllerCallback() {
            /** 
             * @see com.hwc.wx.controller.BaseController.ControllerCallback#execute(com.hwc.wx.dto.UserContext)
             */
            @Override
            public String execute(UserContext context) throws Exception {
                return HttpClient.getResultWithHeader(ServiceUrlConstants.WX_LOGIN, requestjson,
                    context.getToken());
            }

        });
    }

    /**
     * 
     * @param requestjson
     * @param openId
     * @param request
     * @param response
     */
    @PostMapping(value = "/wxBankCode")
    public void wxBankCode(@RequestBody JSONObject requestjson,
                           @RequestHeader(name = "openId", required = false) String openId,
                           HttpServletRequest request, HttpServletResponse response) {
        this.httpExecute(openId, response, new ControllerCallback() {
            /** 
             * @see com.hwc.wx.controller.BaseController.ControllerCallback#execute(com.hwc.wx.dto.UserContext)
             */
            @Override
            public String execute(UserContext context) throws Exception {
                return HttpClient.getResultWithHeader(ServiceUrlConstants.WX_BANK_CODE, requestjson,
                    context.getToken());
            }

        });
    }

    /**
     * 
     * @param requestjson
     * @param openId
     * @param request
     * @param response
     */
    @PostMapping(value = "/wxBank")
    public void wxBank(@RequestBody JSONObject requestjson,
                       @RequestHeader(name = "openId", required = false) String openId,
                       HttpServletRequest request, HttpServletResponse response) {
        this.httpExecute(openId, response, new ControllerCallback() {
            /** 
             * @see com.hwc.wx.controller.BaseController.ControllerCallback#execute(com.hwc.wx.dto.UserContext)
             */
            @Override
            public String execute(UserContext context) throws Exception {
                return HttpClient.getResultWithHeader(ServiceUrlConstants.WX_BANK, requestjson,
                    context.getToken());
            }

        });
    }

    /**
     * 用户登录
     * @param requestjson
     * @param openId
     * @param request
     * @param response
     */
    @PostMapping(value = "/wxBindLogin")
    public void wxBindLogin(@RequestBody JSONObject requestjson,
                            @RequestHeader(name = "openId", required = false) String openId,
                            HttpServletRequest request, HttpServletResponse response) {
        this.httpExecute(openId, response, new ControllerCallback() {
            /** 
             * @see com.hwc.wx.controller.BaseController.ControllerCallback#execute(com.hwc.wx.dto.UserContext)
             */
            @Override
            public String execute(UserContext context) throws Exception {
                return HttpClient.getResultWithHeader(ServiceUrlConstants.LOGIN_USER, requestjson,
                    context.getToken());
            }

        });
    }

    /**
     * 
     * @param requestjson
     * @param openId
     * @param request
     * @param response
     */
    @PostMapping(value = "/updateCat")
    public void updateCat(@RequestBody JSONObject requestjson,
                          @RequestHeader(name = "openId", required = false) String openId,
                          HttpServletRequest request, HttpServletResponse response) {
        this.httpExecute(openId, response, new ControllerCallback() {
            /** 
             * @see com.hwc.wx.controller.BaseController.ControllerCallback#execute(com.hwc.wx.dto.UserContext)
             */
            @Override
            public String execute(UserContext context) throws Exception {
                requestjson.put("id", context.getUserId());
                return HttpClient.getResultWithHeader(ServiceUrlConstants.UPDATE_CAT, requestjson,
                    context.getToken());
            }

        });
    }

    /**
     * 
     * @param requestjson
     * @param openId
     * @param request
     * @param response
     */
    @PostMapping(value = "/wxRegister")
    public void wxRegister(@RequestBody JSONObject requestjson,
                           @RequestHeader(name = "openId", required = false) String openId,
                           HttpServletRequest request, HttpServletResponse response) {
        this.httpExecute(openId, response, new ControllerCallback() {
            /** 
             * @see com.hwc.wx.controller.BaseController.ControllerCallback#execute(com.hwc.wx.dto.UserContext)
             */
            @Override
            public String execute(UserContext context) throws Exception {
                return HttpClient.getResultWithHeader(ServiceUrlConstants.WX_REGISTER, requestjson,
                    context.getToken());
            }

        });
    }

    /**
     * 
     * @param requestjson
     * @param openId
     * @param etoken
     * @param request
     * @param response
     */
    @PostMapping(value = "/sendCode")
    public void sendCode(@RequestBody JSONObject requestjson,
                         @RequestHeader(name = "openId", required = false) String openId,
                         HttpServletResponse response) {

        this.httpExecute(openId, response, new ControllerCallback() {
            /** 
             * @see com.hwc.wx.controller.BaseController.ControllerCallback#execute(com.hwc.wx.dto.UserContext)
             */
            @Override
            public String execute(UserContext context) throws Exception {
                Map<String, String> headers = new HashMap<String, String>();
                headers.put("e", openId);
                if (!FsUtils.strsEmpty(context.getToken())) {
                    headers.put("Authorization", "Bearer " + context.getToken());
                }
                return HttpClient.getResultWithHeaders(ServiceUrlConstants.SEND_CODE, requestjson,
                    headers);
            }
        });
    }

    /**
     * 
     * @param requestjson
     * @param openId
     * @param request
     * @param response
     */
    @PostMapping(value = "/setTradePwd")
    public void setTradePwd(@RequestBody JSONObject requestjson,
                            @RequestHeader(name = "openId", required = false) String openId,
                            HttpServletRequest request, HttpServletResponse response) {
        this.httpExecute(openId, response, new ControllerCallback() {
            /** 
             * @see com.hwc.wx.controller.BaseController.ControllerCallback#execute(com.hwc.wx.dto.UserContext)
             */
            @Override
            public String execute(UserContext context) throws Exception {
                requestjson.put("id", context.getUserId());
                return HttpClient.getResultWithHeader(ServiceUrlConstants.SET_TRADE_PWD,
                    requestjson, context.getToken());
            }

        });
    }

    /**
     * 
     * @param requestjson
     * @param openId
     * @param request
     * @param response
     */
    @PostMapping(value = "/changeTradePwd")
    public void changeTradePwd(@RequestBody JSONObject requestjson,
                               @RequestHeader(name = "openId", required = false) String openId,
                               HttpServletRequest request, HttpServletResponse response) {
        this.httpExecute(openId, response, new ControllerCallback() {
            /** 
             * @see com.hwc.wx.controller.BaseController.ControllerCallback#execute(com.hwc.wx.dto.UserContext)
             */
            @Override
            public String execute(UserContext context) throws Exception {
                requestjson.put("id", context.getUserId());
                return HttpClient.getResultWithHeader(ServiceUrlConstants.CHANGE_TRADE_PWD,
                    requestjson, context.getToken());
            }

        });
    }

    /**
     * 
     * @param requestjson
     * @param openId
     * @param request
     * @param response
     */
    @PostMapping(value = "/resetTradePwd")
    public void resetTradePwd(@RequestBody JSONObject requestjson,
                              @RequestHeader(name = "openId", required = false) String openId,
                              HttpServletRequest request, HttpServletResponse response) {
        this.httpExecute(openId, response, new ControllerCallback() {
            /** 
             * @see com.hwc.wx.controller.BaseController.ControllerCallback#execute(com.hwc.wx.dto.UserContext)
             */
            @Override
            public String execute(UserContext context) throws Exception {
                requestjson.put("userId", context.getUserId());
                return HttpClient.getResultWithHeader(ServiceUrlConstants.RESET_TRADE_PWD,
                    requestjson, context.getToken());
            }

        });
    }

    /**
     * 忘记密码校验
     * @param requestjson
     * @param openId
     * @param request
     * @param response
     */
    @PostMapping(value = "/resetTradePwdPreCheck")
    public void resetTradePwdPreCheck(@RequestBody JSONObject requestjson,
                                      @RequestHeader(name = "openId", required = false) String openId,
                                      HttpServletRequest request, HttpServletResponse response) {
        this.httpExecute(openId, response, new ControllerCallback() {
            /** 
             * @see com.hwc.wx.controller.BaseController.ControllerCallback#execute(com.hwc.wx.dto.UserContext)
             */
            @Override
            public String execute(UserContext context) throws Exception {
                requestjson.put("userId", context.getUserId());
                return HttpClient.getResultWithHeader(ServiceUrlConstants.RESET_TRADE_PWD_PRECHECK,
                    requestjson, context.getToken());
            }

        });
    }

    /**
     * 
     * @param requestjson
     * @param openId
     * @param request
     * @param response
     */
    @PostMapping(value = "/isSetTradePwd")
    public void isSetTradePwd(@RequestBody JSONObject requestjson,
                              @RequestHeader(name = "openId", required = false) String openId,
                              HttpServletRequest request, HttpServletResponse response) {
        this.httpExecute(openId, response, new ControllerCallback() {
            /** 
             * @see com.hwc.wx.controller.BaseController.ControllerCallback#execute(com.hwc.wx.dto.UserContext)
             */
            @Override
            public String execute(UserContext context) throws Exception {
                requestjson.put("id", context.getUserId());
                return HttpClient.getResultWithHeader(ServiceUrlConstants.IS_SET_TRADEPWD,
                    requestjson, context.getToken());
            }

        });
    }

    /**
     * 
     * @param requestjson
     * @param openId
     * @param request
     * @param response
     */
    @PostMapping(value = "/forgetPwd")
    public void forgetPwd(@RequestBody JSONObject requestjson,
                          @RequestHeader(name = "openId", required = false) String openId,
                          HttpServletRequest request, HttpServletResponse response) {
        this.httpExecute(openId, response, new ControllerCallback() {
            /** 
             * @see com.hwc.wx.controller.BaseController.ControllerCallback#execute(com.hwc.wx.dto.UserContext)
             */
            @Override
            public String execute(UserContext context) throws Exception {
                return HttpClient.getResultWithHeader(ServiceUrlConstants.FORGET_PWD, requestjson,
                    context.getToken());
            }

        });
    }

    @PostMapping(value = "/bankcodeList")
    public void bankcodeList(@RequestBody JSONObject requestjson,
                             @RequestHeader(name = "openId", required = false) String openId,
                             HttpServletRequest request, HttpServletResponse response) {
        this.httpExecute(openId, response, new ControllerCallback() {
            /** 
             * @see com.hwc.wx.controller.BaseController.ControllerCallback#execute(com.hwc.wx.dto.UserContext)
             */
            @Override
            public String execute(UserContext context) throws Exception {
                return HttpClient.getResultWithHeader(ServiceUrlConstants.BANKCODE_LIST,
                    requestjson, context.getToken());
            }

        });
    }

    /**
     * 
     * @param requestjson
     * @param openId
     * @param request
     * @param response
     */
    @PostMapping(value = "/basecodeList")
    public void basecodeList(@RequestBody JSONObject requestjson,
                             @RequestHeader(name = "openId", required = false) String openId,
                             HttpServletRequest request, HttpServletResponse response) {
        this.httpExecute(openId, response, new ControllerCallback() {
            /** 
             * @see com.hwc.wx.controller.BaseController.ControllerCallback#execute(com.hwc.wx.dto.UserContext)
             */
            @Override
            public String execute(UserContext context) throws Exception {
                return HttpClient.getResultWithHeader(ServiceUrlConstants.BASECODE_LIST,
                    requestjson, context.getToken());
            }

        });
    }

    /**
     * 获取系统配置
     * @param requestjson
     * @param openId
     * @param request
     * @param response
     */
    @PostMapping(value = "/querySysConfig")
    public void querySysConfig(@RequestBody JSONObject requestjson,
                               @RequestHeader(name = "openId", required = false) String openId,
                               HttpServletRequest request, HttpServletResponse response) {
        this.httpExecute(openId, response, new ControllerCallback() {
            /** 
             * @see com.hwc.wx.controller.BaseController.ControllerCallback#execute(com.hwc.wx.dto.UserContext)
             */
            @Override
            public String execute(UserContext context) throws Exception {
                return HttpClient.getResultWithHeader(ServiceUrlConstants.QUERY_SYS_CONFIG,
                    requestjson, context.getToken());
            }

        });
    }

    /**
     * 
     * @param requestjson
     * @param openId
     * @param request
     * @param response
     */
    @PostMapping(value = "/authSignReturnCW")
    public void authSignReturnCW(@RequestBody JSONObject requestjson,
                                 @RequestHeader(name = "openId", required = false) String openId,
                                 HttpServletRequest request, HttpServletResponse response) {
        this.httpExecute(openId, response, new ControllerCallback() {
            /** 
             * @see com.hwc.wx.controller.BaseController.ControllerCallback#execute(com.hwc.wx.dto.UserContext)
             */
            @Override
            public String execute(UserContext context) throws Exception {
                return HttpClient.getResultWithHeader(ServiceUrlConstants.AUTH_SIGN_RETURN_CW,
                    requestjson, context.getToken());
            }

        });
    }

    /**
     * 获取basecode 扩展信息
     * @param requestjson
     * @param openId
     * @param request
     * @param response
     */
    @PostMapping(value = "/getBankList")
    public void getBankList(@RequestBody JSONObject requestjson,
                            @RequestHeader(name = "openId", required = false) String openId,
                            HttpServletRequest request, HttpServletResponse response) {
        this.httpExecute(openId, response, new ControllerCallback() {
            /** 
             * @see com.hwc.wx.controller.BaseController.ControllerCallback#execute(com.hwc.wx.dto.UserContext)
             */
            @Override
            public String execute(UserContext context) throws Exception {
                return HttpClient.getResultWithHeader(ServiceUrlConstants.GET_BANK_LIST,
                    requestjson, context.getToken());
            }

        });
    }

    /**
     * 
     * @param requestjson
     * @param openId
     * @param request
     * @param response
     */
    @PostMapping(value = "/loginout")
    public void loginout(@RequestBody JSONObject requestjson,
                         @RequestHeader(name = "openId", required = false) String openId,
                         HttpServletRequest request, HttpServletResponse response) {
        this.httpExecute(openId, response, new ControllerCallback() {
            /** 
             * @see com.hwc.wx.controller.BaseController.ControllerCallback#execute(com.hwc.wx.dto.UserContext)
             */
            @Override
            public String execute(UserContext context) throws Exception {
                return HttpClient.getResultWithHeader(ServiceUrlConstants.LOGIN_OUT, requestjson,
                    context.getToken());
            }

        });
    }

    /**
     * 
     * @param requestjson
     * @param openId
     * @param request
     * @param response
     */
    @PostMapping(value = "/changeDLPwd")
    public void changeDLPwd(@RequestBody JSONObject requestjson,
                            @RequestHeader(name = "openId", required = false) String openId,
                            HttpServletRequest request, HttpServletResponse response) {
        this.httpExecute(openId, response, new ControllerCallback() {
            /** 
             * @see com.hwc.wx.controller.BaseController.ControllerCallback#execute(com.hwc.wx.dto.UserContext)
             */
            @Override
            public String execute(UserContext context) throws Exception {
                requestjson.put("id", context.getUserId());
                return HttpClient.getResultWithHeader(ServiceUrlConstants.CHANGE_DL_PWD,
                    requestjson, context.getToken());
            }

        });
    }

    /**
     * 
     * @param requestjson
     * @param openId
     * @param request
     * @param response
     */
    @PostMapping(value = "/getContractUrl")
    public void getContractUrl(@RequestBody JSONObject requestjson,
                               @RequestHeader(name = "openId", required = false) String openId,
                               HttpServletRequest request, HttpServletResponse response) {
        this.httpExecute(openId, response, new ControllerCallback() {
            /** 
             * @see com.hwc.wx.controller.BaseController.ControllerCallback#execute(com.hwc.wx.dto.UserContext)
             */
            @Override
            public String execute(UserContext context) throws Exception {

                //app 端userId会传过来，微信端从后台取
                if (context != null && context.getUserId() > 0) {
                    requestjson.put("userId", context.getUserId());
                }
                return HttpClient.getResultWithHeader(ServiceUrlConstants.GET_CONTRACT_URL,
                    requestjson, context.getToken());
            }

        });
    }

}
