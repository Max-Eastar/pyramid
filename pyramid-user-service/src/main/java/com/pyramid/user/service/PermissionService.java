package com.pyramid.user.service;

import com.pyramid.user.domain.entity.Permission;
import com.pyramid.user.domain.entity.PermissionInRole;
import com.pyramid.user.domain.vo.RoleVO;
import com.pyramid.user.mapper.PermissionInRoleMapper;
import com.pyramid.user.mapper.PermissionMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Service
public class PermissionService {
    @Autowired
    private PermissionMapper permissionMapper;
    @Autowired
    private PermissionInRoleMapper permissionInRoleMapper;

    public boolean add(Permission permission) {
        boolean result = false;
        if (permission == null || StringUtils.isEmpty(permission.getGlobalUniqueResourceId()) || StringUtils.isEmpty(permission.getResourceId()) || StringUtils.isEmpty(permission.getActionCode())) {
            return result;
        }
        permission.setPermissionId(String.format("%s:%s", permission.getGlobalUniqueResourceId(), permission.getActionCode()));
        return permissionMapper.insert(permission) > 0;
    }

    @Transactional
    public boolean update(Permission permission) {
        boolean result = false;
        if (permission == null) {
            return result;
        }
        permissionMapper.deleteByPrimaryKey(permission.getPermissionId());
        permission.setPermissionId(String.format("%s:%s", permission.getGlobalUniqueResourceId(), permission.getActionCode()));
        return permissionMapper.insert(permission) > 0;
    }

    public boolean delete(String permissionId) {
        boolean result = false;
        result = permissionMapper.deleteByPrimaryKey(permissionId) > 0;
        return result;
    }

    public List<Permission> getPermissionsByResourceId(String resourceId) {
        List<Permission> permissions = permissionMapper.selectListByResourceId(resourceId);
        return permissions;
    }

    public List<Permission> getPermissionsByUserId(String userId) {
        List<Permission> permissions = permissionMapper.selectListByUserId(userId);
        return permissions;
    }

    public List<Permission> getPermissionsByRoleId(String roleId) {
        List<Permission> permissions = permissionMapper.selectListByRoleId(roleId);
        return permissions;
    }

    public boolean addPermissionsInRole(Map<String, String> permissionsInRole) {
        boolean result = false;
        if (permissionsInRole == null) {
            return result;
        }

        List<PermissionInRole> permissionInRoles = new ArrayList<>();
        for (Map.Entry<String, String> entry : permissionsInRole.entrySet()) {
            PermissionInRole permissionInRole = new PermissionInRole();
            permissionInRole.setPermissionId(entry.getKey());
            permissionInRole.setRoleId(entry.getValue());
            permissionInRoles.add(permissionInRole);
        }
        result = permissionInRoleMapper.insertBatch(permissionInRoles) > 0;
        return result;
    }

    public boolean removePermissionsFormRole(Map<String, String> permissionsInRole) {
        boolean result = false;
        if (permissionsInRole == null) {
            return result;
        }
        for (Map.Entry<String, String> entry : permissionsInRole.entrySet()) {
            result = permissionInRoleMapper.deleteByPrimaryKey(entry.getValue(), entry.getKey()) > 0;
        }
        return result;
    }

}
