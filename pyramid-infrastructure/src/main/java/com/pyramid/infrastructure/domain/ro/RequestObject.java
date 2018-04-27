package com.pyramid.infrastructure.domain.ro;

public class RequestObject<T> {

    protected T paramValue;

    public T getParamValue() {
        return paramValue;
    }

    public void setParamValue(T paramValue) {
        this.paramValue = paramValue;
    }
}
