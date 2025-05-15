package com.example.FactoryManager.controller;

import com.example.FactoryManager.dto.request.SettingRequest;
import com.example.FactoryManager.dto.response.ApiResponse;
import com.example.FactoryManager.dto.response.SettingResponse;
import com.example.FactoryManager.service.SettingService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AccessLevel;
import lombok.experimental.FieldDefaults;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/Settings")
@Slf4j
@FieldDefaults(level = AccessLevel.PRIVATE)
@Tag(name = "Setting Controller")
public class SettingController {

    @Autowired
    private SettingService settingsService;

    @GetMapping("/get")
    @Operation(
            summary = "Get all settings",
            description = "Returns all settings",
            method = "GET"
    )
    public ApiResponse<SettingResponse> getAllSettings() {
        log.info("Fetching all settings");
        SettingResponse settingResponse = settingsService.getAllSettings();
        return ApiResponse.<SettingResponse>builder()
                .code(200)
                .message("Success")
                .result(settingResponse)
                .build();
    }

    @GetMapping("/{id}")
    @Operation(
            summary = "Get settings by ID",
            description = "Returns settings for the given ID",
            method = "GET"
    )
    public ApiResponse<SettingResponse> getSettings(@PathVariable Long id) {
        log.info("Fetching settings with id: {}", id);
        SettingResponse settingResponse = settingsService.getSettings(id);
        return ApiResponse.<SettingResponse>builder()
                .code(200)
                .message("Success")
                .result(settingResponse)
                .build();
    }

    @PutMapping("/{id}")
    @Operation(
            summary = "Update settings by ID",
            description = "Updates settings for the given ID",
            method = "PUT"
    )
    public ApiResponse<String> updateSettings(@PathVariable Long id, @RequestBody SettingRequest request) {
        log.info("Updating settings with id: {}", id);
        SettingResponse settingResponse = settingsService.updateSettings(id, request);
        return ApiResponse.<String>builder()
                .code(200)
                .message("Settings updated successfully")
                .result("Settings updated successfully")
                .build();
    }
}
