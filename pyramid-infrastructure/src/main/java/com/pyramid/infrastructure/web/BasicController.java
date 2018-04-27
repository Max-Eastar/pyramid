package com.pyramid.infrastructure.web;

import com.pyramid.infrastructure.domain.vo.ActionResult;
import com.pyramid.infrastructure.enums.IErrorCode;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;
import javax.servlet.http.HttpServletRequest;

public class BasicController {

    protected HttpServletRequest getRequest() {
        return ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
    }

    protected ActionResult ActionResult(IErrorCode errorCode) {
        return new ActionResult(errorCode);
    }

    protected ActionResult ActionResult(int errCode, String errMsg) {
        return new ActionResult(errCode, errMsg);
    }

    protected <T> ActionResult<T> ActionResult(T value) {
        return new ActionResult(value);
    }

    protected <T> ActionResult<T> ActionResult(IErrorCode errorCode, T value) {
        return new ActionResult<T>(errorCode, value);
    }

    protected <T> ActionResult<T> ActionResult(IErrorCode errorCode, String errMsg, T value) {
        return new ActionResult<T>(errorCode, errMsg, value);
    }

}
