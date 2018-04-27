package com.pyramid.user.domain.entity;

import java.io.Serializable;

public class Permission implements Serializable {
    private String permissionId;

    private String resourceId;

    private String globalUniqueResourceId;

    private String actionCode;

    private static final long serialVersionUID = 1L;

    public String getPermissionId() {
        return permissionId;
    }

    public void setPermissionId(String permissionId) {
        this.permissionId = permissionId == null ? null : permissionId.trim();
    }

    public String getResourceId() {
        return resourceId;
    }

    public void setResourceId(String resourceId) {
        this.resourceId = resourceId == null ? null : resourceId.trim();
    }

    public String getGlobalUniqueResourceId() {
        return globalUniqueResourceId;
    }

    public void setGlobalUniqueResourceId(String globalUniqueResourceId) {
        this.globalUniqueResourceId = globalUniqueResourceId == null ? null : globalUniqueResourceId.trim();
    }

    public String getActionCode() {
        return actionCode;
    }

    public void setActionCode(String actionCode) {
        this.actionCode = actionCode == null ? null : actionCode.trim();
    }
}