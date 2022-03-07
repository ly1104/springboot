package com.yjxxt.utils;

import com.yjxxt.exception.ParamException;

public class AssignUtil {

    //判断是否抛异常
    public static void isTrue(boolean flag,String msg){
        if(flag){
            throw new ParamException(msg);
        }
    }

}
