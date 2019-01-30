package com.zhuhangjie.girl.exception;

import com.zhuhangjie.girl.enums.ResultEnum;

/**
 * 自动以异常
 * 必须继承RuntimeException，因为Spring框架中只对RuntimeException会进行事务回滚
 */
public class GirlException extends RuntimeException{
    private Integer code;

    public GirlException(ResultEnum resultEnum) {
        super(resultEnum.getMsg());
        this.code = resultEnum.getCode();
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }
}
