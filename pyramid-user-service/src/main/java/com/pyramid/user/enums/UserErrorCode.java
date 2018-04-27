package com.pyramid.user.enums;

import com.pyramid.infrastructure.enums.IErrorCode;

public enum UserErrorCode implements IErrorCode{
    USER_NOT_EXSITS(1, "用户信息不存在"),
    USER_LOGIN_FAILED(2, "密码不正确,登录失败")
    ;

    private String msg;
    private int code;
    private int baseCode=100000;

    private UserErrorCode(int code, String msg) {
        this.code = baseCode+code;
        this.msg = msg;
    }

    public int getBaseCode() {
        return baseCode;
    }

    public int getCode() {
        return code;
    }

    public String getMsg() {
        return msg;
    }
}
