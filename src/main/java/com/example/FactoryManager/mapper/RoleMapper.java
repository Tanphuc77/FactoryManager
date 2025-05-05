package com.example.FactoryManager.mapper;

import com.example.FactoryManager.dto.response.PermissionResponse;
import com.example.FactoryManager.dto.response.RolePermissionResponse;
import com.example.FactoryManager.dto.response.RoleResponse;
import com.example.FactoryManager.entity.Permission;
import com.example.FactoryManager.entity.Role;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface RoleMapper {

    @Mapping(source = "id", target = "roleId")
    RoleResponse toRoleResponse(Role role);

    @Mapping(source = "id", target = "roleId")
    @Mapping(source = "permission", target = "permissions")
    RolePermissionResponse toRolePermissionResponse(Role role);


}
