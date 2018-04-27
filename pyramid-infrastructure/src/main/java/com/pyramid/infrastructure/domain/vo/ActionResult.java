package com.pyramid.infrastructure.domain.vo;

import com.pyramid.infrastructure.enums.ErrorCode;
import com.pyramid.infrastructure.enums.IErrorCode;
import org.springframework.util.StringUtils;

public class ActionResult<T> {
    protected int errCode;
    protected String errMsg;
    protected T value;


    public ActionResult(IErrorCode errorCode) {
        this.errCode = errorCode.getCode();
        this.errMsg = errorCode.getMsg();
        this.value = null;
    }

    public ActionResult(int errCode, String errMsg) {
        this.errCode = errCode;
        if (!StringUtils.isEmpty(errMsg)) {
            this.errMsg = errMsg;
        }
        this.value = null;
    }

    public ActionResult(IErrorCode errorCode, T value) {
        this.errCode = errorCode.getCode();
        this.errMsg = errorCode.getMsg();
        this.value = value;
    }

    public ActionResult(IErrorCode errorCode, String errMsg, T value) {
        this.errCode = errorCode.getCode();
        if (!StringUtils.isEmpty(errMsg)) {
            this.errMsg = errMsg;
        } else {
            this.errMsg = errorCode.getMsg();
        }
        this.value = value;
    }

    public ActionResult(T value) {
        this.value = value;
        if (value == null) {
            this.errCode = ErrorCode.FAILED.getCode();
            this.errMsg = ErrorCode.FAILED.getMsg();
            return;
        }

        Class<?> valueType = value.getClass();
        if (valueType.isInstance(Boolean.class)) {
            ErrorCode errorCode = (Boolean) value ? ErrorCode.SUCCESS : ErrorCode.FAILED;
            this.errCode = errorCode.getCode();
            this.errMsg = errorCode.getMsg();
            return;
        }
        if (valueType.isInstance(Void.class)) {
            this.errCode = ErrorCode.SUCCESS.getCode();
            this.errMsg = ErrorCode.SUCCESS.getMsg();
            return;
        }
        if (valueType.isPrimitive()) {
            ErrorCode errorCode = (Double) value > 0 ? ErrorCode.SUCCESS : ErrorCode.FAILED;
            this.errCode = errorCode.getCode();
            this.errMsg = errorCode.getMsg();
            return;
        }

        this.errCode = ErrorCode.SUCCESS.getCode();
        this.errMsg = ErrorCode.SUCCESS.getMsg();
    }

    public ActionResult<T> Success() {
        return new ActionResult<T>(ErrorCode.SUCCESS);
    }

    public ActionResult<T> Failed() {
        return new ActionResult<T>(ErrorCode.FAILED);
    }
}
