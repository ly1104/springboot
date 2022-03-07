package com.yjxxt;

import com.yjxxt.exception.ParamException;
import com.yjxxt.utils.ResultInfo;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

@ControllerAdvice
public class GlobalExceptionHandler {
    /**
     *  全局异常处理  返回json
     * @param e
     * @return
     */
    @ExceptionHandler(value = Exception.class)
    @ResponseBody
    public ResultInfo exceptionHandler(Exception e){
        ResultInfo resultInfo = new ResultInfo();
        resultInfo.setCode(300);
        resultInfo.setMsg("操作失败!");
        if(e instanceof ParamException){
            ParamException pe = (ParamException) e;
            resultInfo.setMsg(pe.getMsg());
            resultInfo.setCode(pe.getCode());
        }
        return resultInfo;
    }
}
