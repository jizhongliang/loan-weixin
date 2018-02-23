package com.hwc.wx.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.alibaba.fastjson.JSONObject;
import com.hwc.wx.base.ServiceUrlConstants;
import com.hwc.wx.controller.BaseController;
import com.hwc.wx.dto.UserContext;
import com.hwc.wx.utils.HttpClient;

/**
 * 
 * @author jinlilong
 * @version $Id: WxIdenController.java, v 0.1 2018年1月25日 上午10:00:59 jinlilong Exp $
 */
@RestController
@RequestMapping("/wechat/iden/api")
public class IdenController extends BaseController {

    /**
     * 
     * @param requestjson
     * @param openId
     * @param request
     * @param response
     */
    @PostMapping(value = "/getAuth")
    public void getAuth(@RequestBody JSONObject requestjson,
                        @RequestHeader(name = "openId", required = false) String openId,
                        HttpServletRequest request, HttpServletResponse response) {
        this.httpExecute(openId, response, new ControllerCallback() {
            /** 
             * @see com.hwc.wx.controller.BaseController.ControllerCallback#execute(com.hwc.wx.dto.UserContext)
             */
            @Override
            public String execute(UserContext context) throws Exception {
                requestjson.put("id", context.getUserId());
                return HttpClient.getResultWithHeader(ServiceUrlConstants.GET_AUTH, requestjson,
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
    @PostMapping(value = "/getAuthData")
    public void getAuthData(@RequestBody JSONObject requestjson,
                            @RequestHeader(name = "openId", required = false) String openId,
                            HttpServletRequest request, HttpServletResponse response) {
        this.httpExecute(openId, response, new ControllerCallback() {
            /** 
             * @see com.hwc.wx.controller.BaseController.ControllerCallback#execute(com.hwc.wx.dto.UserContext)
             */
            @Override
            public String execute(UserContext context) throws Exception {
                requestjson.put("userId", context.getUserId());
                return HttpClient.getResultWithHeader(ServiceUrlConstants.GET_AUTH_DATA,
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
    @PostMapping(value = "/getEmerContacts")
    public void getEmerContacts(@RequestBody JSONObject requestjson,
                                @RequestHeader(name = "openId", required = false) String openId,
                                HttpServletRequest request, HttpServletResponse response) {
        this.httpExecute(openId, response, new ControllerCallback() {
            /** 
             * @see com.hwc.wx.controller.BaseController.ControllerCallback#execute(com.hwc.wx.dto.UserContext)
             */
            @Override
            public String execute(UserContext context) throws Exception {
                requestjson.put("userId", context.getUserId());
                return HttpClient.getResultWithHeader(ServiceUrlConstants.GET_EMER_CONTACTS,
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
    @PostMapping(value = "/updateEmerContacts")
    public void updateEmerContacts(@RequestBody JSONObject requestjson,
                                   @RequestHeader(name = "openId", required = false) String openId,
                                   HttpServletRequest request, HttpServletResponse response) {
        this.httpExecute(openId, response, new ControllerCallback() {
            /** 
             * @see com.hwc.wx.controller.BaseController.ControllerCallback#execute(com.hwc.wx.dto.UserContext)
             */
            @Override
            public String execute(UserContext context) throws Exception {
                requestjson.put("userId", context.getUserId());
                return HttpClient.getResultWithHeader(ServiceUrlConstants.UPDATE_EMER_CONTACTS,
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
    @PostMapping(value = "/updateUserIdCardInfo")
    public void updateUserIdCardInfo(@RequestBody JSONObject requestjson,
                                     @RequestHeader(name = "openId", required = false) String openId,
                                     HttpServletRequest request, HttpServletResponse response) {
        this.httpExecute(openId, response, new ControllerCallback() {
            /** 
             * @see com.hwc.wx.controller.BaseController.ControllerCallback#execute(com.hwc.wx.dto.UserContext)
             */
            @Override
            public String execute(UserContext context) throws Exception {
                requestjson.put("userId", context.getUserId());
                return HttpClient.getResultWithHeader(ServiceUrlConstants.UPDATE_USERID_CARD_INFO,
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
    @PostMapping(value = "/userInfo")
    public void userInfo(@RequestBody JSONObject requestjson,
                         @RequestHeader(name = "openId", required = false) String openId,
                         HttpServletRequest request, HttpServletResponse response) {
        this.httpExecute(openId, response, new ControllerCallback() {
            /** 
             * @see com.hwc.wx.controller.BaseController.ControllerCallback#execute(com.hwc.wx.dto.UserContext)
             */
            @Override
            public String execute(UserContext context) throws Exception {
                requestjson.put("id", context.getUserId());
                return HttpClient.getResultWithHeader(ServiceUrlConstants.USER_INFO, requestjson,
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
    @PostMapping(value = "/authentication")
    public void authentication(@RequestBody JSONObject requestjson,
                               @RequestHeader(name = "openId", required = false) String openId,
                               HttpServletRequest request, HttpServletResponse response) {
        this.httpExecute(openId, response, new ControllerCallback() {
            /** 
             * @see com.hwc.wx.controller.BaseController.ControllerCallback#execute(com.hwc.wx.dto.UserContext)
             */
            @Override
            public String execute(UserContext context) throws Exception {
                requestjson.put("userId", context.getUserId());
                return HttpClient.getResultWithHeader(ServiceUrlConstants.AUTHENTICATION,
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
    @PostMapping(value = "/parkingAuthentication")
    public void parkingAuthentication(@RequestBody JSONObject requestjson,
                                      @RequestHeader(name = "openId", required = false) String openId,
                                      HttpServletRequest request, HttpServletResponse response) {
        this.httpExecute(openId, response, new ControllerCallback() {
            /** 
             * @see com.hwc.wx.controller.BaseController.ControllerCallback#execute(com.hwc.wx.dto.UserContext)
             */
            @Override
            public String execute(UserContext context) throws Exception {
                requestjson.put("userId", context.getUserId());
                return HttpClient.getResultWithHeader(ServiceUrlConstants.PARKING_AUTHENTICATION,
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
    @PostMapping(value = "/configh")
    public void configh(@RequestBody JSONObject requestjson,
                        @RequestHeader(name = "openId", required = false) String openId,
                        HttpServletRequest request, HttpServletResponse response) {
        this.httpExecute(openId, response, new ControllerCallback() {
            /** 
             * @see com.hwc.wx.controller.BaseController.ControllerCallback#execute(com.hwc.wx.dto.UserContext)
             */
            @Override
            public String execute(UserContext context) throws Exception {
                return HttpClient.getResultWithHeader(ServiceUrlConstants.QUERY_CONFIG_IDEN,
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
    @PostMapping(value = "/getCarrierUrl")
    public void getCarrierUrl(@RequestBody JSONObject requestjson,
                              @RequestHeader(name = "openId", required = false) String openId,
                              HttpServletRequest request, HttpServletResponse response) {
        this.httpExecute(openId, response, new ControllerCallback() {
            /** 
             * @see com.hwc.wx.controller.BaseController.ControllerCallback#execute(com.hwc.wx.dto.UserContext)
             */
            @Override
            public String execute(UserContext context) throws Exception {
                requestjson.put("id", context.getUserId());
                return HttpClient.getResultWithHeader(ServiceUrlConstants.GET_CARRIER_URL,
                    requestjson, context.getToken());
            }

        });
    }
}
