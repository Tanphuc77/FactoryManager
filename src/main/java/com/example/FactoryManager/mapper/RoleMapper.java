package com.example.FactoryManager.mapper;

import com.example.FactoryManager.dto.response.RoleResponse;
import com.example.FactoryManager.entity.Role;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface RoleMapper {

    @Mapping(source = "id", target = "roleId")
    RoleResponse toRoleResponse(Role role);
}
