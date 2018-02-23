/**
 * Copyright (c) 2018 All Rights Reserved.
 */
package com.hwc.wx.base;

/**
 * 
 * @author jinlilong
 * @version $Id: ServiceUrlConstants.java, v 0.1 2018年1月24日 上午11:05:37 jinlilong Exp $
 */
public class ServiceUrlConstants {

    //用户相关

    /**  获取用户的基础信息存于上下文*/
    public static final String QUERY_USER_CONTEXT_DATA  = "/api/user/getWxUserContextData";

    /**  获取用户银行卡信息*/
    public static final String GET_BANK_CARD_INFO       = "/api/bank/card/getBankCardInfo";

    /**  用户登录*/
    public static final String LOGIN_USER               = "/api/user/wxBindLogin";

    /**  获取配置*/
    public static final String BASECODE_LIST            = "/api/sys/basecodeList";

    /**  判断是否已设置密码*/
    public static final String IS_SET_TRADEPWD          = "/api/user/isSetTradePwd";

    /**  获取用户的额度*/
    public static final String GET_QUOTA                = "/api/credit/getQuota";

    /**  修改交易密码*/
    public static final String CHANGE_TRADE_PWD         = "/api/user/changeTradePwd";

    /**  发送验证码*/
    public static final String SEND_CODE                = "/api/sms/sendCodeWx";

    /**  发送验证码校验用户信息填写是否正确*/
    public static final String RESET_TRADE_PWD_PRECHECK = "/api/user/resetTradePwdPreCheck";

    /**  重置交易密码*/
    public static final String RESET_TRADE_PWD          = "/api/user/resetTradePwd";

    /**  设置车位还是信用*/
    public static final String UPDATE_CAT               = "/api/user/updateCat";

    /**  忘记登录密码*/
    public static final String FORGET_PWD               = "/api/user/forgetPwd";

    /**  用户注册*/
    public static final String WX_REGISTER              = "/api/user/wxRegister";

    /**  设置交易密码*/
    public static final String SET_TRADE_PWD            = "/api/user/setTradePwd";

    /**  */
    public static final String CHANGE_DL_PWD            = "/api/user/changeDLPwd";

    //iden相关
    /**  查询配置*/
    public static final String QUERY_CONFIG_IDEN        = "/api/sys/config/h5";

    /**  车位预绑卡和绑卡*/
    public static final String AUTH_SIGN_RETURN_CW      = "/api/bank/card/authSignReturnCW";

    /**  */
    public static final String GET_AUTH                 = "/api/user/auth/getAuth";

    /**  */
    public static final String GET_AUTH_DATA            = "/api/bank/card/getAuthData";

    /**  */
    public static final String GET_EMER_CONTACTS        = "/api/user/auth/getEmerContacts";

    /**  */
    public static final String UPDATE_EMER_CONTACTS     = "/api/user/auth/updateEmerContacts";

    /**  */
    public static final String UPDATE_USERID_CARD_INFO  = "/api/user/baseInfo/updateUserIdCardInfo";

    /**  */
    public static final String USER_INFO                = "/api/user/baseInfo/userInfo";

    /**  */
    public static final String AUTHENTICATION           = "/api/user/auth/authentication";

    /**  */
    public static final String PARKING_AUTHENTICATION   = "/api/user/auth/parkingAuthentication";

    /**  */
    public static final String GET_CARRIER_URL          = "/api/user/auth/getCarrierUrl";

    /**  */
    public static final String WX_LOGIN                 = "/api/user/wxLogin";

    //borrow相关

    /**  车位首页请求地址*/
    public static final String QUERY_MORTGAGE_INDEX     = "/api/mortgage/borrow/index";

    /**  预还款计划*/
    public static final String REPAY_PLAN_LIST          = "/api/borrow/repay/repayPlanList";

    /**  本期还款列表详情*/
    public static final String REPAY_DETAIL             = "/api/borrow/repay/repayDetail";

    /**  本期还款*/
    public static final String REPAYMENT                = "/api/pay/repayment";

    /**  获取提前还款详情*/
    public static final String CALC_PRE_PAYMENT         = "/api/borrow/repay/calcPrePayment";

    /**  提前还款*/
    public static final String PRE_REPAYMENT            = "/api/pay/preRepayment";

    /**  借款列表*/
    public static final String BORROW_LIST              = "/api/borrow/repay/borrowList";

    /**  还款列表*/
    public static final String BORROW_REPAY_LIST        = "/api/borrow/repay/log/borrowRepayList";

    /**  还款计划*/
    public static final String REPAY_PLAN_DETAIL        = "/api/borrow/repay/repayPlanDetail";

    /**  */
    public static final String MBAPPLY                  = "/api/mortgage/apply";

    /**  */
    public static final String BANNER                   = "/api/mortgage/borrow/banner";

    /**  */
    public static final String WITH_DRAW                = "/api/mortgage/borrow/withdraw";

    /**  */
    public static final String CBINDEX                  = "/api/credit/borrow/index";

    /**  */
    public static final String CBAPPLY                  = "/api/credit/borrow/apply";

    /**  */
    public static final String CREPAY_PLAN_LIST         = "/api/borrow/repay/credit/repayPlanList";

    /**  */
    public static final String REPAY                    = "/api/p2p/repay";

    /**  */
    public static final String PRE_REPAY_CHECK          = "/api/borrow/repay/preRepayCheck";

    /**  */
    public static final String MREPAY_PLAN_DETAIL       = "/api/borrow/repay/mortgage/repayPlanDetail";

    /**  */
    public static final String CONTRACT_CREDIT          = "/api/contract/credit";

    /**  */
    public static final String CONTRACT_MORTGAGE        = "/api/contract/mortgage";

    /**  */
    public static final String CALC_FIRST_REPAY         = "/api/borrow/repay/calcFirstRepay";

    /**  */
    public static final String UP_IMAGE                 = "/api/mortgage/upImage";

    /**  */
    public static final String INFO                     = "/api/mortgage/info";

    /**  */
    public static final String CREDIT_LIST              = "/api/contract/creditList";

    //common相关
    public static final String QUERY_SYS_CONFIG         = "/api/sys/config/querySysConfig";

    /**  */
    public static final String BANKCODE_LIST            = "/api/sys/bankcodeList";

    /**  */
    public static final String WX_BANK_CODE             = "/api/bank/card/getBank";

    /**  */
    public static final String WX_BANK                  = "/api/bank/card/Bank";

    /**  */
    public static final String AUTH_SIGN_RETURN         = "/api/bank/card/authSignReturn";

    /**  */
    public static final String GET_BANK_LIST            = "/api/bank/card/getBankList";

    /**  */
    public static final String LOGIN_OUT                = "/api/user/loginout";

    /**  */
    public static final String EQREGISTER               = "/api/user/equipment/register";

    /**  */
    public static final String GET_CONTRACT_URL         = "/api/contract/getContractUrl";

}
