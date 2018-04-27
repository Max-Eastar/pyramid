package com.pyramid.infrastructure.enums;

import java.util.prefs.AbstractPreferences;

public enum AppInfo {
    WeMall(1000, "微信商城", AppType.Wechat),
    MerchantPlatform(2000, "商户管理平台", AppType.Web),
    OperatePlatform(3000, "运营管理平台", AppType.Web),;

    private int appId;
    private String appName;
    private int appType;

    private AppInfo(int appId, String appName, AppType appType) {
        this.appId = appId;
        this.appName = appName;
        this.appType = appType.getCode();
    }

    public int getAppId() {
        return appId;
    }

    public void setAppId(int appId) {
        this.appId = appId;
    }

    public String getAppName() {
        return appName;
    }

    public void setAppName(String appName) {
        this.appName = appName;
    }

    public int getAppType() {
        return appType;
    }

    public void setAppType(int appType) {
        this.appType = appType;
    }
}
