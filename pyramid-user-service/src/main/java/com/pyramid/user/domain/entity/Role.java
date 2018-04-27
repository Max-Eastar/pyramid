package com.pyramid.user.domain.entity;

import java.io.Serializable;
import java.util.Date;

public class Role implements Serializable {
    private String roleId;

    private String roleName;

    private String appId;

    private String appName;

    private Integer appType;

    private Byte isSys;

    private String lastOperId;

    private String lastOperName;

    private Date lastOperTime;

    private Byte isDel;

    private static final long serialVersionUID = 1L;

    public String getRoleId() {
        return roleId;
    }

    public void setRoleId(String roleId) {
        this.roleId = roleId == null ? null : roleId.trim();
    }

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName == null ? null : roleName.trim();
    }

    public String getAppId() {
        return appId;
    }

    public void setAppId(String appId) {
        this.appId = appId == null ? null : appId.trim();
    }

    public String getAppName() {
        return appName;
    }

    public void setAppName(String appName) {
        this.appName = appName == null ? null : appName.trim();
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
        this.lastOperId = lastOperId == null ? null : lastOperId.trim();
    }

    public String getLastOperName() {
        return lastOperName;
    }

    public void setLastOperName(String lastOperName) {
        this.lastOperName = lastOperName == null ? null : lastOperName.trim();
    }

    public Date getLastOperTime() {
        return lastOperTime;
    }

    public void setLastOperTime(Date lastOperTime) {
        this.lastOperTime = lastOperTime;
    }

    public Byte getIsDel() {
        return isDel;
    }

    public void setIsDel(Byte isDel) {
        this.isDel = isDel;
    }
}