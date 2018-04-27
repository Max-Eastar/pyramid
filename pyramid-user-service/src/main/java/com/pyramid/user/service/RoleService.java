package com.pyramid.user.service;

import com.pyramid.infrastructure.utils.BeanConvertUtils;
import com.pyramid.user.domain.entity.Role;
import com.pyramid.user.domain.entity.UserInRole;
import com.pyramid.user.domain.ro.RoleRO;
import com.pyramid.user.domain.vo.RoleVO;
import com.pyramid.user.mapper.RoleMapper;
import com.pyramid.user.mapper.UserInRoleMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

@Service
public class RoleService {
    @Autowired
    private RoleMapper roleMapper;
    @Autowired
    private UserInRoleMapper userInRoleMapper;

    public boolean add(RoleRO roleRO) {
        boolean result = false;
        Role role = null;
        if (roleRO == null) {
            return result;
        }
        BeanConvertUtils.copyProperties(role, roleRO);
        role.setLastOperTime(new Date());
        role.setIsDel((byte) 0);
        role.setIsSys((byte) 0);
        return roleMapper.insert(role) > 0;
    }

    public boolean update(RoleRO roleRO) {
        boolean result = false;
        Role role = null;
        if (roleRO == null) {
            return result;
        }
        BeanConvertUtils.copyProperties(role, roleRO);
        return roleMapper.updateByPrimaryKeySelective(role) > 0;
    }

    public boolean delete(String roleId) {
        boolean result = false;
        Role role = roleMapper.selectByPrimaryKey(roleId);
        if (role == null) {
            return result;
        }
        role.setIsDel((byte) 1);
        return roleMapper.updateByPrimaryKeySelective(role) > 0;
    }

    public List<RoleVO> getRoles() {
        List<RoleVO> roles = roleMapper.selectList();
        return roles;
    }

    public List<RoleVO> getRoles(String userId) {
        List<RoleVO> roles = roleMapper.selectListByUserId(userId);
        return roles;
    }

    public boolean addUsersInRole(Map<String, String> usersInRole) {
        boolean result = false;
        if (usersInRole == null) {
            return result;
        }
        List<UserInRole> userInRoles = new ArrayList<>();
        for (Map.Entry<String, String> entry : usersInRole.entrySet()) {
            UserInRole userInRole = new UserInRole();
            userInRole.setUserId(entry.getKey());
            userInRole.setRoleId(entry.getValue());
            userInRoles.add(userInRole);
        }
        result = userInRoleMapper.insertBatch(userInRoles) > 0;
        return result;
    }

    public boolean removeUsersFormRole(Map<String, String> usersInRole) {
        boolean result = false;
        if (usersInRole == null) {
            return result;
        }
        for (Map.Entry<String, String> entry : usersInRole.entrySet()) {
            result = userInRoleMapper.deleteByPrimaryKey(entry.getValue(), entry.getKey()) > 0;
        }
        return result;
    }
}
