package com.yjxxt.exception;

public class ParamException extends RuntimeException {
    //状态码
    private Integer code=300;
    //异常提示信息
    private String msg="参数异常";

    public ParamException() {
        super("参数异常");
    }

    public ParamException(Integer code) {
        super("参数异常");
        this.code=code;
    }

    public ParamException(String msg) {
        super(msg);
        this.msg=msg;
    }

    public ParamException(Integer code,String msg) {
        super(msg);
        this.msg=msg;
        this.code=code;
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

    @Override
    public String toString() {
        return "ParamException{" +
                "code=" + code +
                ", msg='" + msg + '\'' +
                '}';
    }
}
