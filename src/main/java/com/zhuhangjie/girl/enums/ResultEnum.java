package com.zhuhangjie.girl.enums;

public enum ResultEnum {
    UNKONW_ERROR(-1,"位置错误"),
    SUCCESS(0, "成功"),
    PRIMART_SCHOOL(100,"你可能还在上小学"),
    MIDDLE_SCHOOLE(101,"你可能在上初中")
    ;

    private Integer code;
    
    private String msg;

    ResultEnum(Integer code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public Integer getCode() {
        return code;
    }

    public String getMsg() {
        return msg;
    }

}
