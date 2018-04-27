package com.pyramid.infrastructure.exception;

import com.pyramid.infrastructure.domain.vo.ActionResult;
import com.pyramid.infrastructure.enums.ErrorCode;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

public class ErrorExceptionHandler {
    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @ExceptionHandler(Exception.class)
    @ResponseBody
    public ActionResult handleException(Exception e) {
        if (e != null && !StringUtils.isEmpty(e.getMessage())) {
            logger.error("错误异常", e);
        }
        return new ActionResult(ErrorCode.UNKNOWN_EXCETION.getCode(),e.getMessage());
    }

    @ExceptionHandler(ErrorException.class)
    @ResponseBody
    public ActionResult handleException(ErrorException e) {
        if (e != null && !StringUtils.isEmpty(e.getMessage())) {
            logger.error("错误异常", e);
        }
        if(e.getErrObject()==null) {
            return new ActionResult(ErrorCode.FAILED.getCode(),e.getMessage());
        }
        return new ActionResult(e.getErrObject());
    }

}
