package com.pyramid.infrastructure.exception;

import com.pyramid.infrastructure.enums.IErrorCode;

public class ErrorException extends Exception {
    private int errCode;
    private String errMsg;
    private IErrorCode errObject;

    public ErrorException() {
    }

    public ErrorException(String message, Throwable cause) {
        super(message, cause);
    }

    public ErrorException(String message) {
        super(message);
    }

    public ErrorException(IErrorCode errorCode) {
        super(String.format("[%s]:%s", errorCode.getCode(), errorCode.getMsg()));
        this.errObject=errorCode;
        this.errCode = errorCode.getCode();
        this.errMsg = errorCode.getMsg();
    }

    public int getErrCode() {
        return this.errCode;
    }

    public String getErrMsg() {
        return this.errMsg;
    }

    public IErrorCode getErrObject() {
        return errObject;
    }
}
