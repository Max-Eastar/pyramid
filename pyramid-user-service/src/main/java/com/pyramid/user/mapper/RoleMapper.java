package com.pyramid.user.mapper;

import com.pyramid.user.domain.entity.Role;
import com.pyramid.user.domain.vo.RoleVO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface RoleMapper {
    int deleteByPrimaryKey(String roleId);

    int insert(Role record);

    int insertSelective(Role record);

    Role selectByPrimaryKey(String roleId);

    int updateByPrimaryKeySelective(Role record);

    int updateByPrimaryKey(Role record);

    List<RoleVO> selectList();

    List<RoleVO> selectListByUserId(@Param("userId") String userId);

}