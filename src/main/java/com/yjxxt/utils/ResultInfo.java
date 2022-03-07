package com.yjxxt.utils;


import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(description = "响应结果 - Model信息")
public class ResultInfo {

    @ApiModelProperty(value = "响应状态码",example = "200")
    private Integer code=200;
    @ApiModelProperty(value = "响应消息结果")
    private String msg="操作成功";
    @ApiModelProperty(value = "响应具体结果信息")
    private Object result;

    public ResultInfo() {
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public Object getResult() {
        return result;
    }

    public void setResult(Object result) {
        this.result = result;
    }

    @Override
    public String toString() {
        return "ResultInfo{" +
                "code=" + code +
                ", msg='" + msg + '\'' +
                ", result=" + result +
                '}';
    }
}
