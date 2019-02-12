package com.huhaoran.esproject.enums;

import lombok.Getter;

@Getter
public enum  ResultEnum {
    SUCCESS(0, "成功"),
    BAD_REQUEST(400, "Bad Request"),
    INTERNAL_SERVER_ERROR(500, "Unknow Internal Server Error"),
    NOT_VAILD_PARAMS(40005, "Not Vaild Params"),
    NOT_SUPPORT_OPERATION(40006, "Not Support Operation"),
    NOT_LOGIN(50000, "Not Login");

    private int code;
    private String msg;
    ResultEnum(int code, String msg) {
        this.code = code;
        this.msg = msg;
    }
}
