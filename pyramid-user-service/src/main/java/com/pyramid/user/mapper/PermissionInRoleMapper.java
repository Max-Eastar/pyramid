package com.pyramid.user.mapper;

import com.pyramid.user.domain.entity.PermissionInRole;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface PermissionInRoleMapper {
    int deleteByPrimaryKey(@Param("roleId") String roleId, @Param("permissionId") String permissionId);

    int insert(PermissionInRole record);

    int insertSelective(PermissionInRole record);

    int insertBatch(List<PermissionInRole> records);

}