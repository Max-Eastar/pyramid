package com.pyramid.user.mapper;

import com.pyramid.user.domain.entity.UserInRole;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

@Mapper
public interface UserInRoleMapper {
    int deleteByPrimaryKey(@Param("roleId") String roleId, @Param("userId") String userId);

    int insert(UserInRole record);

    int insertSelective(UserInRole record);

    int insertBatch(List<UserInRole> records);

}