package com.example.FactoryManager.dto.response;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.Data;
import lombok.experimental.FieldDefaults;

import java.util.Set;

@Data
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
public class RolePermissionResponse {

    int roleId;

    String name;

    String description;

    Set<PermissionResponse> permissions;
}
