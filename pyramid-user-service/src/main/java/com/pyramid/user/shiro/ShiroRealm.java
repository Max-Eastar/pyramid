package com.pyramid.user.shiro;

import com.pyramid.user.domain.entity.Permission;
import com.pyramid.user.domain.vo.RoleVO;
import com.pyramid.user.domain.vo.UserVO;
import com.pyramid.user.service.PermissionService;
import com.pyramid.user.service.RoleService;
import com.pyramid.user.service.UserService;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;

import javax.xml.ws.WebEndpoint;
import java.util.List;

@Configuration
public class ShiroRealm extends AuthorizingRealm {
    @Autowired
    private UserService userService;

    @Autowired
    private RoleService roleService;

    @Autowired
    private PermissionService permissionService;

    @Override
    public String getName() {
        return "ShiroRealm";
    }

    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
        UsernamePasswordToken myToken = (UsernamePasswordToken) authenticationToken;

        String loginName = (String) myToken.getPrincipal();
        UserVO userVO = userService.getUserByLoginName(loginName);
        if (userVO == null) {
            throw new UnknownAccountException();
        }
        SimpleAuthenticationInfo authenticationInfo = new SimpleAuthenticationInfo(
                userVO,
                userVO.getLoginPwd(),
                getName()
        );
        return authenticationInfo;
    }

    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        UserVO user = (UserVO) SecurityUtils.getSubject().getPrincipal();
        if (user == null) {
            throw new UnknownAccountException();
        }
        List<Permission> permissions = permissionService.getPermissionsByUserId(user.getUserId());
        List<RoleVO> roles = roleService.getRoles(user.getUserId());
        SimpleAuthorizationInfo info = new SimpleAuthorizationInfo();
        for (Permission permission : permissions) {
            info.addStringPermission(permission.getPermissionId());
        }
        for (RoleVO roleVO : roles) {
            info.addRole(roleVO.getRoleId());
        }
        return info;
    }
}
