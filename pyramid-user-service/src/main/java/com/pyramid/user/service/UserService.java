package com.pyramid.user.service;

import com.pyramid.infrastructure.enums.ErrorCode;
import com.pyramid.infrastructure.utils.BeanConvertUtils;
import com.pyramid.infrastructure.exception.ErrorException;
import com.pyramid.user.enums.UserErrorCode;
import com.pyramid.user.domain.entity.User;
import com.pyramid.user.domain.ro.UserRO;
import com.pyramid.user.domain.vo.UserVO;
import com.pyramid.user.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.Date;

@Service
public class UserService {
    @Autowired
    private UserMapper userMapper;

    public boolean add(UserRO userRO) {
        boolean result = false;
        User user = null;
        if (userRO == null) {
            return result;
        }
        BeanConvertUtils.copyProperties(user, userRO);
        user.setCreateTime(new Date());
        user.setIsFirstLogin((byte) 0);
        user.setIsDel((byte) 0);
        user.setIsLock((byte) 0);
        return userMapper.insert(user) > 0;
    }

    public boolean update(UserRO userRO) {
        boolean result = false;
        User user = null;
        if (userRO == null) {
            return result;
        }
        BeanConvertUtils.copyProperties(user, userRO);
        return userMapper.updateByPrimaryKeySelective(user) > 0;
    }

    public boolean delete(String userId) {
        boolean result = false;
        User user = userMapper.selectByPrimaryKey(userId);
        if (user == null) {
            return result;
        }
        user.setIsDel((byte) 1);
        return userMapper.updateByPrimaryKeySelective(user) > 0;
    }

    public UserVO getUserById(String userId) {
        UserVO userVO = null;
        User user = userMapper.selectByPrimaryKey(userId);
        if (user != null) {
            BeanConvertUtils.copyProperties(userVO, user);
        }
        return userVO;
    }

    public UserVO getUserByLoginName(String loginName) {
        UserVO userVO = null;
        User user = userMapper.selectByLoginName(loginName);
        if (user != null) {
            BeanConvertUtils.copyProperties(userVO, user);
        }
        return userVO;
    }

    public boolean login(String loginName, String password) throws ErrorException {
        boolean result = false;
        if (StringUtils.isEmpty(loginName) || StringUtils.isEmpty(password)) {
            throw new ErrorException(ErrorCode.PARAMS_IS_NULL);
        }
        User user = userMapper.selectByLoginName(loginName);
        if (user == null) {
            throw new ErrorException(UserErrorCode.USER_NOT_EXSITS);
        }
        if (!password.equals(user.getLoginPwd())) {
            throw new ErrorException(UserErrorCode.USER_LOGIN_FAILED);
        }
        return result = true;
    }

}
