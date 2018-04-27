package com.pyramid.infrastructure.enums;

public enum ErrorCode implements IErrorCode {
    SUCCESS(0, "操作成功"),
    FAILED(1, "操作失败"),
    UNKNOWN_EXCETION(101,"系统异常,请稍后再试"),
    PARAMS_IS_NULL(102, "参数为空,操作失败"),
    TIMEOUT(103,"操作超时"),
    AUTHENTICATION_EXCEPTION(104,"身份认证失败"),
    AUTHORIZATION_EXCEPTION(105,"授权失败,权限不足")
    ;


    private int code;
    private String msg;
    private int baseCode=0;

    private ErrorCode(int code, String msg) {
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
