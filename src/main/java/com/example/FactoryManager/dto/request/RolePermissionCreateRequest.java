package com.example.FactoryManager.dto.request;

import com.example.FactoryManager.entity.Role;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.util.Set;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
public class RolePermissionCreateRequest {

    String name;

    Set<Integer> permissionIds;
}
