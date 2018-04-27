package com.pyramid.user.controller;

import com.pyramid.infrastructure.domain.vo.ActionResult;
import com.pyramid.infrastructure.web.BasicController;
import com.pyramid.user.service.UserService;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.apache.shiro.authz.annotation.RequiresRoles;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AccountController extends BasicController {
    @Autowired
    private UserService userService;

    @RequiresPermissions("account:login")
    @RequiresRoles("admin")
    public ActionResult login(String loginName, String password) throws Exception {

        boolean result = userService.login(loginName, password);
        return ActionResult(result);
    }

    @RequiresPermissions("account:login")
    @RequiresRoles("admin")
    public ActionResult login2(String loginName, String password) throws Exception {
        Subject subject = SecurityUtils.getSubject();
        UsernamePasswordToken token = new UsernamePasswordToken(loginName, password, true);
        subject.login(token);
        return ActionResult(subject.isAuthenticated());
    }
}
