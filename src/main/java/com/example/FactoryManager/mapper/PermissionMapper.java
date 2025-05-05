package com.example.FactoryManager.mapper;

import com.example.FactoryManager.dto.response.PermissionResponse;
import com.example.FactoryManager.entity.Permission;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface PermissionMapper {

    @Mapping(source = "id", target = "permissionId")
    PermissionResponse toPermissionResponse(Permission permission);
}
