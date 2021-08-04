package com.mayikt.mapper;

import java.security.Permission;
import java.util.List;

import com.mayikt.entity.PermissionEntity;
import org.apache.ibatis.annotations.Select;


public interface PermissionMapper {

    @Select(" select * from sys_permission ")
    List<PermissionEntity> findAllPermission();

}
