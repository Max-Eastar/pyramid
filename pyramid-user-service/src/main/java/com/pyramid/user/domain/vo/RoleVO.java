package com.pyramid.user.domain.vo;

public class RoleVO {
    private String roleId;

    private String roleName;

    private String appId;

    private String appName;

    private Integer appType;

    private Byte isSys;

    public String getRoleId() {
        return roleId;
    }

    public void setRoleId(String roleId) {
        this.roleId = roleId;
    }

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

    public String getAppId() {
        return appId;
    }

    public void setAppId(String appId) {
        this.appId = appId;
    }

    public String getAppName() {
        return appName;
    }

    public void setAppName(String appName) {
        this.appName = appName;
    }

    public Integer getAppType() {
        return appType;
    }

    public void setAppType(Integer appType) {
        this.appType = appType;
    }

    public Byte getIsSys() {
        return isSys;
    }

    public void setIsSys(Byte isSys) {
        this.isSys = isSys;
    }
}
