package com.example.FactoryManager.controller;

import com.example.FactoryManager.dto.request.UIConfigRequest;
import com.example.FactoryManager.dto.response.ApiResponse;
import com.example.FactoryManager.dto.response.UIConfigResponse;
import com.example.FactoryManager.entity.User;
import com.example.FactoryManager.exception.AppException;
import com.example.FactoryManager.mapper.UIMapper;
import com.example.FactoryManager.service.UIConfigService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AccessLevel;
import lombok.experimental.FieldDefaults;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.oauth2.jwt.Jwt;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/uiconfig")
@Slf4j
@FieldDefaults(level = AccessLevel.PRIVATE)
@Tag(name = "UIConfig Controller")
public class UIController {

    @Autowired
    UIConfigService uiConfigService;

    @Autowired
    UIMapper uiMapper;

   @PutMapping("/save")
   @Operation(
            summary = "Save UI configuration",
            description = "Saves the UI configuration for a user",
            method = "PUT"
    )
    public ApiResponse<UIConfigResponse> saveUIConfig(@RequestBody UIConfigRequest uiConfigRequest) {
        log.info("Saving UI config for user: {}", uiConfigRequest.getUserId());
        UIConfigResponse response = uiConfigService.saveUIConfig(uiConfigRequest);
        return ApiResponse.<UIConfigResponse>builder()
                .code(200)
                .message("Success")
                .result(response)
                .build();
    }

    @GetMapping("/current")
    @Operation(
            summary = "Get current UI configuration for authenticated user",
            description = "Retrieves the UI configuration for the authenticated user and specified screen"
    )
    public ApiResponse<UIConfigResponse> getUserCurrentUIConfig(
            Authentication authentication,
            @RequestParam(required = false) String screenCode) {
        try {
            log.info("Fetching UI config for user: {}", authentication.getName());
            String username = authentication.getName();
            log.info("Username: {}", username);
            User user = uiConfigService.loadUserById(username);
            UIConfigResponse response = uiConfigService.getUserCurrentUIConfig(user, screenCode);

            return ApiResponse.<UIConfigResponse>builder()
                    .code(200)
                    .message("Success")
                    .result(response)
                    .build();
        } catch (AppException e) {
            return ApiResponse.<UIConfigResponse>builder()
                    .code(e.getErrorCode().getCode())
                    .message(e.getMessage())
                    .build();
        } catch (Exception e) {
            return ApiResponse.<UIConfigResponse>builder()
                    .code(500)
                    .message("Internal Server Error: " + e.getMessage())
                    .build();
        }
    }

}

