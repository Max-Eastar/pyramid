package com.pyramid.user.shiro;

import com.pyramid.infrastructure.domain.vo.ActionResult;
import com.pyramid.infrastructure.enums.ErrorCode;
import com.pyramid.infrastructure.exception.ErrorExceptionHandler;
import com.pyramid.user.service.ResourceService;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authz.AuthorizationException;
import org.apache.shiro.realm.Realm;
import org.apache.shiro.spring.web.config.DefaultShiroFilterChainDefinition;
import org.apache.shiro.spring.web.config.ShiroFilterChainDefinition;
import org.apache.shiro.subject.Subject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpStatus;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.ResponseStatus;

import javax.naming.AuthenticationException;
import java.util.HashMap;
import java.util.Map;

@Configuration
@ControllerAdvice
public class ShiroConfig extends ErrorExceptionHandler {
    private static Logger logger = LoggerFactory.getLogger(ShiroConfig.class);

    @ExceptionHandler(AuthorizationException.class)
    @ResponseStatus(HttpStatus.FORBIDDEN)
    public ActionResult handleException(AuthorizationException e, Model model) {
        logger.error(ErrorCode.AUTHORIZATION_EXCEPTION.getMsg(), e);

        Map<String, Object> map = new HashMap<String, Object>();
        map.put("status", HttpStatus.FORBIDDEN.value());
        map.put("message", ErrorCode.AUTHORIZATION_EXCEPTION.getMsg());
        model.addAttribute("errors", map);
        return new ActionResult(ErrorCode.AUTHORIZATION_EXCEPTION);
     }

    @ExceptionHandler(AuthenticationException.class)
    @ResponseStatus(HttpStatus.UNAUTHORIZED)
    public ActionResult handleException(AuthenticationException e, Model model) {
        logger.error(ErrorCode.AUTHENTICATION_EXCEPTION.getMsg(), e);

        Map<String, Object> map = new HashMap<String, Object>();
        map.put("status", HttpStatus.FORBIDDEN.value());
        map.put("message", ErrorCode.AUTHENTICATION_EXCEPTION.getMsg());
        model.addAttribute("errors", map);
        return new ActionResult(ErrorCode.AUTHENTICATION_EXCEPTION);
    }

    @Bean
    public Realm realm() {
        ShiroRealm realm = new ShiroRealm();
        realm.setCachingEnabled(true);
        return realm;
    }

    @Bean
    public ShiroFilterChainDefinition shiroFilterChainDefinition() {
        DefaultShiroFilterChainDefinition chainDefinition = new DefaultShiroFilterChainDefinition();
        //chainDefinition.addPathDefinition("/login.html", "authc"); // need to accept POSTs from the login form
        //拦截器
        ResourceService resourceService = new ResourceService();
        Map<String, String> filterChainDefinitionMap = resourceService.getFilterDefinitions();
        chainDefinition.addPathDefinitions(filterChainDefinitionMap);
//        Map<String,String> filterChainDefinitionMap = new LinkedHashMap<String,String>();
//        filterChainDefinitionMap.put("/css/**","anon");
//        filterChainDefinitionMap.put("/js/**","anon");
//        filterChainDefinitionMap.put("/img/**","anon");
//        filterChainDefinitionMap.put("/font-awesome/**","anon");
        return chainDefinition;
    }

    @ModelAttribute(name = "subject")
    public Subject subject() {
        return SecurityUtils.getSubject();
    }
}
