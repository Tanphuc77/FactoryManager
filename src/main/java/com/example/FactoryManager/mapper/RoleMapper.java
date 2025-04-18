package com.example.FactoryManager.mapper;

import com.example.FactoryManager.dto.response.RoleResponse;
import com.example.FactoryManager.entity.Role;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface RoleMapper {

    RoleResponse toRoleResponse(Role role);
}
