package com.zhuhangjie.girl.handle;

import com.zhuhangjie.girl.entity.Girl;
import com.zhuhangjie.girl.entity.Result;
import com.zhuhangjie.girl.exception.GirlException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import utils.ResultUtil;

@ControllerAdvice
public class ExceptionHandle {

    private final static Logger logger = LoggerFactory.getLogger(ExceptionHandle.class);

    @ExceptionHandler(value = Exception.class)
    @ResponseBody
    public Result handle(Exception e) {
        if (e instanceof GirlException) {
            GirlException girlException = (GirlException) e;
            return  ResultUtil.error(girlException.getCode(),girlException.getMessage());
        } else {
            logger.error("【系统异常】{}",e);
            return ResultUtil.error(-1,"未知错误");
        }
    }
}
