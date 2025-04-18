package com.example.FactoryManager.controller;

import com.example.FactoryManager.dto.response.ApiResponse;
import com.example.FactoryManager.dto.response.RoleResponse;
import com.example.FactoryManager.service.RoleService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AccessLevel;
import lombok.experimental.FieldDefaults;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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


}
