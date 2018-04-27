package com.pyramid.user.domain.entity;

import java.io.Serializable;

public class Resource implements Serializable {
    private String resourceId;

    private String resourceName;

    private String appId;

    private String appName;

    private String parentId;

    private String globalUniqueResourceId;

    private Byte isEnable;

    private String filterAntPath;

    private String filterDefinition;

    private static final long serialVersionUID = 1L;

    public String getResourceId() {
        return resourceId;
    }

    public void setResourceId(String resourceId) {
        this.resourceId = resourceId == null ? null : resourceId.trim();
    }

    public String getResourceName() {
        return resourceName;
    }

    public void setResourceName(String resourceName) {
        this.resourceName = resourceName == null ? null : resourceName.trim();
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

    public String getParentId() {
        return parentId;
    }

    public void setParentId(String parentId) {
        this.parentId = parentId == null ? null : parentId.trim();
    }

    public String getGlobalUniqueResourceId() {
        return globalUniqueResourceId;
    }

    public void setGlobalUniqueResourceId(String globalUniqueResourceId) {
        this.globalUniqueResourceId = globalUniqueResourceId == null ? null : globalUniqueResourceId.trim();
    }

    public Byte getIsEnable() {
        return isEnable;
    }

    public void setIsEnable(Byte isEnable) {
        this.isEnable = isEnable;
    }

    public String getFilterAntPath() {
        return filterAntPath;
    }

    public void setFilterAntPath(String filterAntPath) {
        this.filterAntPath = filterAntPath == null ? null : filterAntPath.trim();
    }

    public String getFilterDefinition() {
        return filterDefinition;
    }

    public void setFilterDefinition(String filterDefinition) {
        this.filterDefinition = filterDefinition == null ? null : filterDefinition.trim();
    }
}