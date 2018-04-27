package com.pyramid.infrastructure.enums;

public enum AppType {
    Web(1, "Web应用"),
    Android(2, "安卓应用"),
    Apple(3, "苹果应用"),
    Wechat(4, "微信公众号"),
    WechatSmall(5, "微信小程序")
    ;


    private int code;
    private String msg;

    private AppType(int code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }
}
