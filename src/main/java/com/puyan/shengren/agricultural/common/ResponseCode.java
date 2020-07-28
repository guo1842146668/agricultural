package com.puyan.shengren.agricultural.common;

/**
 * @ClassName: ResponseCode
 * @Description: TODO
 * @Author: idmin
 * @Date: 2020/7/21 16:52
 * @Version: 1.0
 **/
public enum ResponseCode {
    SUCCESS(200,"SUCCESS"),
    ERROR(500,"ERROR"),
    NEED_LOGIN(10,"NEED_LOGIN"),
    DATA_NULL(100,"DATA_NULL"),
    ;

    private final int code;
    private final String desc;

    ResponseCode(int code, String desc) {
        this.code = code;
        this.desc = desc;
    }

    public int getCode(){
        return code;
    }

    public String getDesc(){
        return desc;
    }
}
