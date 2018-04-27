package com.pyramid.user.domain.ro;

import java.util.Date;

public class RoleRO {
    private String roleId;

    private String roleName;

    private String appId;

    private String appName;

    private Integer appType;

    private Byte isSys;

    private String lastOperId;

    private String lastOperName;

    private Date lastOperTime;

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

    public String getLastOperId() {
        return lastOperId;
    }

    public void setLastOperId(String lastOperId) {
        this.lastOperId = lastOperId;
    }

    public String getLastOperName() {
        return lastOperName;
    }

    public void setLastOperName(String lastOperName) {
        this.lastOperName = lastOperName;
    }

    public Date getLastOperTime() {
        return lastOperTime;
    }

    public void setLastOperTime(Date lastOperTime) {
        this.lastOperTime = lastOperTime;
    }
}
