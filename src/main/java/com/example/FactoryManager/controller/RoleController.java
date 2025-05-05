package com.example.FactoryManager.controller;

import com.example.FactoryManager.dto.request.RolePermissionRequest;
import com.example.FactoryManager.dto.response.ApiResponse;
import com.example.FactoryManager.dto.response.RolePermissionResponse;
import com.example.FactoryManager.dto.response.RoleResponse;
import com.example.FactoryManager.service.RoleService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AccessLevel;
import lombok.experimental.FieldDefaults;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/roles")
@Slf4j
@FieldDefaults(level = AccessLevel.PRIVATE)
@Tag(name = "Role Controller")
public class RoleController {

    @Autowired
    RoleService roleService;

    @GetMapping("/get")
    @Operation(
            summary = "Get list of roles",
            description = "Returns a list of roles",
            method = "GET"
    )
    ApiResponse<List<RoleResponse>> getAllRoles() {
        log.info("Fetching all roles");
        List<RoleResponse> roleResponses = roleService.getAllRoles();
        return ApiResponse.<List<RoleResponse>>builder()
                .code(200)
                .message("Success")
                .result(roleResponses)
                .build();
    }

    @GetMapping("/get-with-permissions")
    @Operation(
            summary = "Get list of roles with permissions",
            description = "Returns a list of roles with permissions",
            method = "GET"
    )
    ApiResponse<List<RolePermissionResponse>> getAllRolesWithPermissions() {
        log.info("Fetching all roles with permissions");
        List<RolePermissionResponse> rolePermissionResponses = roleService.getAllRolesWithPermissions();
        return ApiResponse.<List<RolePermissionResponse>>builder()
                .code(200)
                .message("Success")
                .result(rolePermissionResponses)
                .build();
    }

    @GetMapping("/{roleId}")
    @Operation(
            summary = "Get role by ID",
            description = "Returns a role by ID",
            method = "GET"
    )
    ApiResponse<RolePermissionResponse> getRoleById(@PathVariable int roleId) {
        log.info("Fetching role by ID");
        RolePermissionResponse rolePermissionResponse = roleService.getRoleById(roleId);
        return ApiResponse.<RolePermissionResponse>builder()
                .code(200)
                .message("Success")
                .result(rolePermissionResponse)
                .build();
    }

    @PutMapping("/{roleId}/assign-permissions")
    @Operation(
            summary = "Assign permissions to role",
            description = "Assigns permissions to a role",
            method = "PUT"
    )
    ApiResponse<String> assignPermissionsToRole(
            @PathVariable int roleId,
            @RequestBody RolePermissionRequest rolePermissionRequest) {
        log.info("Assigning permissions to role");
        roleService.assignPermissionsToRole(roleId,rolePermissionRequest);
        return ApiResponse.<String>builder()
                .code(200)
                .message("Success")
                .build();
    }


}
