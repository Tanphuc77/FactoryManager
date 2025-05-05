package com.example.FactoryManager.mapper;

import com.example.FactoryManager.dto.request.RolePermissionCreateRequest;
import com.example.FactoryManager.dto.request.RolePermissionRequest;
import com.example.FactoryManager.dto.request.UserCreateRequest;
import com.example.FactoryManager.dto.response.PermissionResponse;
import com.example.FactoryManager.dto.response.RolePermissionResponse;
import com.example.FactoryManager.dto.response.RoleResponse;
import com.example.FactoryManager.entity.Permission;
import com.example.FactoryManager.entity.Role;
import com.example.FactoryManager.entity.User;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring", uses = {PermissionMapper.class})
public interface RoleMapper {

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "permission", ignore = true)
    Role toRolePermission(RolePermissionCreateRequest request);

    @Mapping(source = "id", target = "roleId")
    RoleResponse toRoleResponse(Role role);

    @Mapping(source = "id", target = "roleId")
    @Mapping(source = "permission", target = "permissions")
    RolePermissionResponse toRolePermissionResponse(Role role);


}
