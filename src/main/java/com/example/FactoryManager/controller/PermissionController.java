package com.example.FactoryManager.controller;

import com.example.FactoryManager.dto.response.ApiResponse;
import com.example.FactoryManager.dto.response.PermissionResponse;
import com.example.FactoryManager.service.PermissionService;
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
@RequestMapping("/permissions")
@Slf4j
@FieldDefaults(level = AccessLevel.PRIVATE)
@Tag(name = "Permission Controller")
public class PermissionController {

    @Autowired
     PermissionService permissionService;

     @GetMapping("/get")
     @Operation(
             summary = "Get list of permissions",
             description = "Returns a list of permissions",
             method = "GET"
     )
     ApiResponse<List<PermissionResponse>> getAllPermissions() {
         log.info("Fetching all permissions");
         List<PermissionResponse> permissionResponses = permissionService.getAllPermissions();
         return ApiResponse.<List<PermissionResponse>>builder()
                 .code(200)
                 .message("Success")
                 .result(permissionResponses)
                 .build();
     }
}
