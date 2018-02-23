package com.hwc.wx.base;

/**
 * 
 * @author jinlilong
 * @version $Id: BaseBizErrorEnums.java, v 0.1 2017年12月13日 下午2:07:32 jinlilong Exp $
 */
public enum BaseBizErrorEnums {

    SYSTEM_ERROR("SYSTEM_ERROR", "服务器拥挤，请稍后再试!");

    /**  */
    private String code;

    /**  */
    private String msg;

    BaseBizErrorEnums(String code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    /**
     * Getter method for property <tt>code</tt>.
     * 
     * @return property value of code
     */
    public String getCode() {
        return code;
    }

    /**
     * Setter method for property <tt>code</tt>.
     * 
     * @param code value to be assigned to property code
     */
    public void setCode(String code) {
        this.code = code;
    }

    /**
     * Getter method for property <tt>msg</tt>.
     * 
     * @return property value of msg
     */
    public String getMsg() {
        return msg;
    }

    /**
     * Setter method for property <tt>msg</tt>.
     * 
     * @param msg value to be assigned to property msg
     */
    public void setMsg(String msg) {
        this.msg = msg;
    }

}
