package com.example.train.common.controller;

import com.example.train.common.exception.BusinessException;
import com.example.train.common.resp.CommonResp;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.validation.BindException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * 统一异常处理、数据预处理等
 */
@ControllerAdvice
public class ControllerExceptionHandler {

    private static final Logger LOG = LoggerFactory.getLogger(ControllerExceptionHandler.class);

    /**
     * 所有异常统一处理
     * @param e
     * @return
     */
    @ExceptionHandler(value = Exception.class)
    @ResponseBody
    public CommonResp exceptionHandler(Exception e)  {
        CommonResp commonResp = new CommonResp();
        LOG.error("系统异常：", e);
        commonResp.setSuccess(false);
        commonResp.setMessage("系统出现异常，请联系管理员");
//        commonResp.setMessage(e.getMessage());
        return commonResp;
    }
    /**
     * 业务异常统一处理
     * @param e
     * @return
     */
    @ExceptionHandler(value = BusinessException.class)
    @ResponseBody
    public CommonResp exceptionHandler(BusinessException e)  {
        CommonResp commonResp = new CommonResp();
        LOG.error("业务异常：{}", e.getE().getDesc());
        commonResp.setSuccess(false);
        // commonResp.setMessage("系统出现异常，请联系管理员");
        commonResp.setMessage(e.getE().getDesc());//getE()就是具体的异常（枚举值），getDesc()是得到枚举值的描述
        return commonResp;
    }
    /**
     * 校验异常统一处理
     * @param e
     * @return
     */
    @ExceptionHandler(value = org.springframework.validation.BindException.class)
    @ResponseBody
    public CommonResp exceptionHandler(BindException e)  {
        CommonResp commonResp = new CommonResp();
        LOG.error("校验异常：{}", e.getBindingResult().getAllErrors().get(0).getDefaultMessage());
        commonResp.setSuccess(false);
        // commonResp.setMessage("系统出现异常，请联系管理员");
        commonResp.setMessage(e.getBindingResult().getAllErrors().get(0).getDefaultMessage());//getE()就是具体的异常（枚举值），getDesc()是得到枚举值的描述
        return commonResp;
    }


}