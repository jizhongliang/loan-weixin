/**
 * Copyright (c) 2018 All Rights Reserved.
 */
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
import com.hwc.wx.dto.UserContext;
import com.hwc.wx.utils.HttpClient;

/**
 * 
 * @author jinlilong
 * @version $Id: BorrowController.java, v 0.1 2018年1月25日 上午9:05:53 jinlilong Exp $
 */
@RestController
@RequestMapping("/wechat/borrow/api")
public class BorrowController extends BaseController {

    /**
     * 车位首页
     * @param requestjson
     * @param openId
     * @param request
     * @param response
     */
    @PostMapping(value = "/mortgage/index")
    public void mortgageIndex(@RequestBody JSONObject requestjson,
                              @RequestHeader(name = "openId", required = false) String openId,
                              HttpServletRequest request, HttpServletResponse response) {
        this.httpExecute(openId, response, new ControllerCallback() {
            /** 
             * @see com.hwc.wx.controller.BaseController.ControllerCallback#execute(com.hwc.wx.dto.UserContext)
             */
            @Override
            public String execute(UserContext context) throws Exception {
                requestjson.put("id", context.getUserId());
                return HttpClient.getResultWithHeader(ServiceUrlConstants.QUERY_MORTGAGE_INDEX,
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
    @PostMapping(value = "/mortgage/apply")
    public void mortgageApply(@RequestBody JSONObject requestjson,
                              @RequestHeader(name = "openId", required = false) String openId,
                              HttpServletRequest request, HttpServletResponse response) {
        this.httpExecute(openId, response, new ControllerCallback() {
            /** 
             * @see com.hwc.wx.controller.BaseController.ControllerCallback#execute(com.hwc.wx.dto.UserContext)
             */
            @Override
            public String execute(UserContext context) throws Exception {
                requestjson.put("userId", context.getUserId());
                return HttpClient.getResultWithHeader(ServiceUrlConstants.MBAPPLY, requestjson,
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
    @PostMapping(value = "/mortgage/banner")
    public void mortgageBanner(@RequestBody JSONObject requestjson,
                               @RequestHeader(name = "openId", required = false) String openId,
                               HttpServletRequest request, HttpServletResponse response) {
        this.httpExecute(openId, response, new ControllerCallback() {

            /** 
             * @see com.hwc.wx.controller.BaseController.ControllerCallback#execute(com.hwc.wx.dto.UserContext)
             */
            @Override
            public String execute(UserContext context) throws Exception {
                return HttpClient.getResultWithHeader(ServiceUrlConstants.BANNER, requestjson,
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
    @PostMapping(value = "/withdraw")
    public void withdraw(@RequestBody JSONObject requestjson,
                         @RequestHeader(name = "openId", required = false) String openId,
                         HttpServletRequest request, HttpServletResponse response) {

        this.httpExecute(openId, response, new ControllerCallback() {

            /** 
             * @see com.hwc.wx.controller.BaseController.ControllerCallback#execute(com.hwc.wx.dto.UserContext)
             */
            @Override
            public String execute(UserContext context) throws Exception {
                requestjson.put("userId", context.getUserId());
                return HttpClient.getResultWithHeader(ServiceUrlConstants.WITH_DRAW, requestjson,
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
    @PostMapping(value = "/getQuota")
    public void getQuota(@RequestBody JSONObject requestjson,
                         @RequestHeader(name = "openId", required = false) String openId,
                         HttpServletRequest request, HttpServletResponse response) {

        this.httpExecute(openId, response, new ControllerCallback() {

            /** 
             * @see com.hwc.wx.controller.BaseController.ControllerCallback#execute(com.hwc.wx.dto.UserContext)
             */
            @Override
            public String execute(UserContext context) throws Exception {
                requestjson.put("id", context.getUserId());
                return HttpClient.getResultWithHeader(ServiceUrlConstants.GET_QUOTA, requestjson,
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
    @PostMapping(value = "/repayPlanList")
    public void repayPlanList(@RequestBody JSONObject requestjson,
                              @RequestHeader(name = "openId", required = false) String openId,
                              HttpServletRequest request, HttpServletResponse response) {

        this.httpExecute(openId, response, new ControllerCallback() {

            /** 
             * @see com.hwc.wx.controller.BaseController.ControllerCallback#execute(com.hwc.wx.dto.UserContext)
             */
            @Override
            public String execute(UserContext context) throws Exception {
                requestjson.put("userId", context.getUserId());
                return HttpClient.getResultWithHeader(ServiceUrlConstants.REPAY_PLAN_LIST,
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
    @PostMapping(value = "/credit/index")
    public void creditIndex(@RequestBody JSONObject requestjson,
                            @RequestHeader(name = "openId", required = false) String openId,
                            HttpServletRequest request, HttpServletResponse response) {

        this.httpExecute(openId, response, new ControllerCallback() {

            /** 
             * @see com.hwc.wx.controller.BaseController.ControllerCallback#execute(com.hwc.wx.dto.UserContext)
             */
            @Override
            public String execute(UserContext context) throws Exception {
                requestjson.put("id", context.getUserId());
                return HttpClient.getResultWithHeader(ServiceUrlConstants.CBINDEX, requestjson,
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
    @PostMapping(value = "/credit/apply")
    public void creditApply(@RequestBody JSONObject requestjson,
                            @RequestHeader(name = "openId", required = false) String openId,
                            HttpServletRequest request, HttpServletResponse response) {

        this.httpExecute(openId, response, new ControllerCallback() {

            /** 
             * @see com.hwc.wx.controller.BaseController.ControllerCallback#execute(com.hwc.wx.dto.UserContext)
             */
            @Override
            public String execute(UserContext context) throws Exception {
                requestjson.put("userId", context.getUserId());
                return HttpClient.getResultWithHeader(ServiceUrlConstants.CBAPPLY, requestjson,
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
    @PostMapping(value = "/credit/repayPlanList")
    public void crepayPlanList(@RequestBody JSONObject requestjson,
                               @RequestHeader(name = "openId", required = false) String openId,
                               HttpServletRequest request, HttpServletResponse response) {
        this.httpExecute(openId, response, new ControllerCallback() {

            /** 
             * @see com.hwc.wx.controller.BaseController.ControllerCallback#execute(com.hwc.wx.dto.UserContext)
             */
            @Override
            public String execute(UserContext context) throws Exception {
                requestjson.put("userId", context.getUserId());
                return HttpClient.getResultWithHeader(ServiceUrlConstants.CREPAY_PLAN_LIST,
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
    @PostMapping(value = "/calcPrePayment")
    public void calcPrePayment(@RequestBody JSONObject requestjson,
                               @RequestHeader(name = "openId", required = false) String openId,
                               HttpServletRequest request, HttpServletResponse response) {
        this.httpExecute(openId, response, new ControllerCallback() {

            /** 
             * @see com.hwc.wx.controller.BaseController.ControllerCallback#execute(com.hwc.wx.dto.UserContext)
             */
            @Override
            public String execute(UserContext context) throws Exception {
                return HttpClient.getResultWithHeader(ServiceUrlConstants.CALC_PRE_PAYMENT,
                    requestjson, context.getToken());
            }

        });
    }

    /**
     * 提前还款
     * @param requestjson
     * @param openId
     * @param request
     * @param response
     */
    @PostMapping(value = "/preRepayment")
    public void preRepayment(@RequestBody JSONObject requestjson,
                             @RequestHeader(name = "openId", required = false) String openId,
                             HttpServletRequest request, HttpServletResponse response) {
        this.httpExecute(openId, response, new ControllerCallback() {

            /** 
             * @see com.hwc.wx.controller.BaseController.ControllerCallback#execute(com.hwc.wx.dto.UserContext)
             */
            @Override
            public String execute(UserContext context) throws Exception {
                return HttpClient.getResultWithHeader(ServiceUrlConstants.PRE_REPAYMENT,
                    requestjson, context.getToken());
            }

        });
    }

    /**
     * 还款（提前和本期 ）
     * userId(String):     用户id
       borrowId(String):   借款id
       type(String):"1"    还款类型 1:当期还款 2:提前还款
     * @param requestjson
     * @param openId
     * @param request
     * @param response
     */
    @PostMapping(value = "/repay")
    public void repay(@RequestBody JSONObject requestjson,
                      @RequestHeader(name = "openId", required = false) String openId,
                      HttpServletRequest request, HttpServletResponse response) {
        this.httpExecute(openId, response, new ControllerCallback() {

            /** 
             * @see com.hwc.wx.controller.BaseController.ControllerCallback#execute(com.hwc.wx.dto.UserContext)
             */
            @Override
            public String execute(UserContext context) throws Exception {
                requestjson.put("userId", context.getUserId());
                return HttpClient.getResultWithHeader(ServiceUrlConstants.REPAY, requestjson,
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
    @PostMapping(value = "/preRepayCheck")
    public void preRepayCheck(@RequestBody JSONObject requestjson,
                              @RequestHeader(name = "openId", required = false) String openId,
                              HttpServletRequest request, HttpServletResponse response) {
        this.httpExecute(openId, response, new ControllerCallback() {

            /** 
             * @see com.hwc.wx.controller.BaseController.ControllerCallback#execute(com.hwc.wx.dto.UserContext)
             */
            @Override
            public String execute(UserContext context) throws Exception {
                return HttpClient.getResultWithHeader(ServiceUrlConstants.PRE_REPAY_CHECK,
                    requestjson, context.getToken());
            }

        });
    }

    /**
     * 本期还款
     * @param requestjson
     * @param openId
     * @param request
     * @param response
     */
    @PostMapping(value = "/repayment")
    public void repayment(@RequestBody JSONObject requestjson,
                          @RequestHeader(name = "openId", required = false) String openId,
                          HttpServletRequest request, HttpServletResponse response) {
        this.httpExecute(openId, response, new ControllerCallback() {

            /** 
             * @see com.hwc.wx.controller.BaseController.ControllerCallback#execute(com.hwc.wx.dto.UserContext)
             */
            @Override
            public String execute(UserContext context) throws Exception {
                return HttpClient.getResultWithHeader(ServiceUrlConstants.REPAYMENT, requestjson,
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
    @PostMapping(value = "/repayPlanDetail")
    public void repayPlanDetail(@RequestBody JSONObject requestjson,
                                @RequestHeader(name = "openId", required = false) String openId,
                                HttpServletRequest request, HttpServletResponse response) {
        this.httpExecute(openId, response, new ControllerCallback() {

            /** 
             * @see com.hwc.wx.controller.BaseController.ControllerCallback#execute(com.hwc.wx.dto.UserContext)
             */
            @Override
            public String execute(UserContext context) throws Exception {
                return HttpClient.getResultWithHeader(ServiceUrlConstants.REPAY_PLAN_DETAIL,
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
    @PostMapping(value = "/repayDetail")
    public void repayDetail(@RequestBody JSONObject requestjson,
                            @RequestHeader(name = "openId", required = false) String openId,
                            HttpServletRequest request, HttpServletResponse response) {
        this.httpExecute(openId, response, new ControllerCallback() {

            /** 
             * @see com.hwc.wx.controller.BaseController.ControllerCallback#execute(com.hwc.wx.dto.UserContext)
             */
            @Override
            public String execute(UserContext context) throws Exception {
                return HttpClient.getResultWithHeader(ServiceUrlConstants.REPAY_DETAIL, requestjson,
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
    @PostMapping(value = "/mortgage/repayPlanDetail")
    public void mrepayPlanDetail(@RequestBody JSONObject requestjson,
                                 @RequestHeader(name = "openId", required = false) String openId,
                                 HttpServletRequest request, HttpServletResponse response) {
        this.httpExecute(openId, response, new ControllerCallback() {

            /** 
             * @see com.hwc.wx.controller.BaseController.ControllerCallback#execute(com.hwc.wx.dto.UserContext)
             */
            @Override
            public String execute(UserContext context) throws Exception {
                return HttpClient.getResultWithHeader(ServiceUrlConstants.MREPAY_PLAN_DETAIL,
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
    @PostMapping(value = "/borrowList")
    public void borrowList(@RequestBody JSONObject requestjson,
                           @RequestHeader(name = "openId", required = false) String openId,
                           HttpServletRequest request, HttpServletResponse response) {
        this.httpExecute(openId, response, new ControllerCallback() {

            /** 
             * @see com.hwc.wx.controller.BaseController.ControllerCallback#execute(com.hwc.wx.dto.UserContext)
             */
            @Override
            public String execute(UserContext context) throws Exception {
                requestjson.put("id", context.getUserId());
                return HttpClient.getResultWithHeader(ServiceUrlConstants.BORROW_LIST, requestjson,
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
    @PostMapping(value = "/borrowRepayList")
    public void borrowRepayList(@RequestBody JSONObject requestjson,
                                @RequestHeader(name = "openId", required = false) String openId,
                                HttpServletRequest request, HttpServletResponse response) {
        this.httpExecute(openId, response, new ControllerCallback() {

            /** 
             * @see com.hwc.wx.controller.BaseController.ControllerCallback#execute(com.hwc.wx.dto.UserContext)
             */
            @Override
            public String execute(UserContext context) throws Exception {
                requestjson.put("id", context.getUserId());
                return HttpClient.getResultWithHeader(ServiceUrlConstants.BORROW_REPAY_LIST,
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
    @PostMapping(value = "/authSignReturn")
    public void authSignReturn(@RequestBody JSONObject requestjson,
                               @RequestHeader(name = "openId", required = false) String openId,
                               HttpServletRequest request, HttpServletResponse response) {
        this.httpExecute(openId, response, new ControllerCallback() {

            /** 
             * @see com.hwc.wx.controller.BaseController.ControllerCallback#execute(com.hwc.wx.dto.UserContext)
             */
            @Override
            public String execute(UserContext context) throws Exception {
                requestjson.put("user_id", context.getUserId());
                return HttpClient.getResultWithHeader(ServiceUrlConstants.AUTH_SIGN_RETURN,
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
    @PostMapping(value = "/contract/credit")
    public void contractCredit(@RequestBody JSONObject requestjson,
                               @RequestHeader(name = "openId", required = false) String openId,
                               HttpServletRequest request, HttpServletResponse response) {
        this.httpExecute(openId, response, new ControllerCallback() {

            /** 
             * @see com.hwc.wx.controller.BaseController.ControllerCallback#execute(com.hwc.wx.dto.UserContext)
             */
            @Override
            public String execute(UserContext context) throws Exception {
                requestjson.put("userId", context.getUserId());
                return HttpClient.getResultWithHeader(ServiceUrlConstants.CONTRACT_CREDIT,
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
    @PostMapping(value = "/contract/mortgage")
    public void contractMortgage(@RequestBody JSONObject requestjson,
                                 @RequestHeader(name = "openId", required = false) String openId,
                                 HttpServletRequest request, HttpServletResponse response) {
        this.httpExecute(openId, response, new ControllerCallback() {

            /** 
             * @see com.hwc.wx.controller.BaseController.ControllerCallback#execute(com.hwc.wx.dto.UserContext)
             */
            @Override
            public String execute(UserContext context) throws Exception {
                requestjson.put("userId", context.getUserId());
                return HttpClient.getResultWithHeader(ServiceUrlConstants.CONTRACT_MORTGAGE,
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
    @PostMapping(value = "/calcFirstRepay")
    public void calcFirstRepay(@RequestBody JSONObject requestjson,
                               @RequestHeader(name = "openId", required = false) String openId,
                               HttpServletRequest request, HttpServletResponse response) {
        this.httpExecute(openId, response, new ControllerCallback() {

            /** 
             * @see com.hwc.wx.controller.BaseController.ControllerCallback#execute(com.hwc.wx.dto.UserContext)
             */
            @Override
            public String execute(UserContext context) throws Exception {
                return HttpClient.getResultWithHeader(ServiceUrlConstants.CALC_FIRST_REPAY,
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
    @PostMapping(value = "/upImage")
    public void upImage(@RequestBody JSONObject requestjson,
                        @RequestHeader(name = "openId", required = false) String openId,
                        HttpServletRequest request, HttpServletResponse response) {
        this.httpExecute(openId, response, new ControllerCallback() {

            /** 
             * @see com.hwc.wx.controller.BaseController.ControllerCallback#execute(com.hwc.wx.dto.UserContext)
             */
            @Override
            public String execute(UserContext context) throws Exception {
                requestjson.put("userId", context.getUserId());
                return HttpClient.getResultWithHeader(ServiceUrlConstants.UP_IMAGE, requestjson,
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
    @PostMapping(value = "/info")
    public void info(@RequestBody JSONObject requestjson,
                     @RequestHeader(name = "openId", required = false) String openId,
                     HttpServletRequest request, HttpServletResponse response) {
        this.httpExecute(openId, response, new ControllerCallback() {

            /** 
             * @see com.hwc.wx.controller.BaseController.ControllerCallback#execute(com.hwc.wx.dto.UserContext)
             */
            @Override
            public String execute(UserContext context) throws Exception {
                return HttpClient.getResultWithHeader(ServiceUrlConstants.INFO, requestjson,
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
    @PostMapping(value = "/creditList")
    public void creditList(@RequestBody JSONObject requestjson,
                           @RequestHeader(name = "openId", required = false) String openId,
                           HttpServletRequest request, HttpServletResponse response) {
        this.httpExecute(openId, response, new ControllerCallback() {

            /** 
             * @see com.hwc.wx.controller.BaseController.ControllerCallback#execute(com.hwc.wx.dto.UserContext)
             */
            @Override
            public String execute(UserContext context) throws Exception {
                requestjson.put("userId", context.getUserId());
                return HttpClient.getResultWithHeader(ServiceUrlConstants.CREDIT_LIST, requestjson,
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
    @PostMapping(value = "/getBankCardInfo")
    public void getBankCardInfo(@RequestBody JSONObject requestjson,
                                @RequestHeader(name = "openId", required = false) String openId,
                                HttpServletRequest request, HttpServletResponse response) {
        this.httpExecute(openId, response, new ControllerCallback() {

            /** 
             * @see com.hwc.wx.controller.BaseController.ControllerCallback#execute(com.hwc.wx.dto.UserContext)
             */
            @Override
            public String execute(UserContext context) throws Exception {
                requestjson.put("id", context.getUserId());
                return HttpClient.getResultWithHeader(ServiceUrlConstants.GET_BANK_CARD_INFO,
                    requestjson, context.getToken());
            }

        });
    }
}
