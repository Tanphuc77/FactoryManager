package com.example.FactoryManager.controller;

import com.example.FactoryManager.dto.request.UserCreateRequest;
import com.example.FactoryManager.dto.response.ApiResponse;
import com.example.FactoryManager.dto.response.PageResponse;
import com.example.FactoryManager.dto.response.UserDetailResponse;
import com.example.FactoryManager.dto.response.UserResponse;
import com.example.FactoryManager.service.UserService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AccessLevel;
import lombok.experimental.FieldDefaults;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.UUID;

@RestController
@RequestMapping("/users")
@Slf4j
@FieldDefaults(level = AccessLevel.PRIVATE)
@Tag(name = "User Controller")
public class UserController {

    @Autowired
    UserService userService;

    @GetMapping("/get")
    @Operation(
            summary = "Get list of users",
            description = "Returns a paging list of users",
            method = "GET"
    )
    ApiResponse<PageResponse<UserResponse>> getAllUsers(
            @RequestParam(value = "page", defaultValue = "0") int page,
            @RequestParam(value = "size", defaultValue = "10") int size) {
        log.info("Fetching all users");
        PageResponse<UserResponse> pageResponse = userService.getAllUsers(page, size);
        return ApiResponse.<PageResponse<UserResponse>>builder()
                .code(200)
                .message("Success")
                .result(pageResponse)
                .build();
    }
    @GetMapping("/get/{id}")
    @Operation(
            summary = "Get user by ID",
            description = "Returns user information by ID",
            method = "GET"
    )
    ApiResponse<UserDetailResponse> getUserById(@PathVariable String id) {
        log.info("Fetching user by ID: {}", id);
        UserDetailResponse userDetailResponse = userService.getUserById(id);
        return ApiResponse.<UserDetailResponse>builder()
                .code(200)
                .message("Success")
                .result(userDetailResponse)
                .build();
    }

    @GetMapping("/getmyinfo")
    @Operation(
            summary = "Get my information",
            description = "Returns the information of the currently logged-in user",
            method = "GET"
    )
    ApiResponse<UserResponse> getMyInfo() {
        log.info("Fetching my information");
        UserResponse userResponse = userService.getMyInfo();
        return ApiResponse.<UserResponse>builder()
                .code(200)
                .message("Success")
                .result(userResponse)
                .build();
    }

    @PostMapping("/create")
    @Operation(
            summary = "Create new user account",
            description = "Allows creating new accounts with information such as email, password, role,...",
            method = "POST"
    )
    public ApiResponse<UserResponse> createUser(@RequestBody UserCreateRequest userCreateRequest) {
        log.info("Creating user");
        UserResponse userResponse = userService.createUser(userCreateRequest);
        return ApiResponse.<UserResponse>builder()
                .code(200)
                .message("Success")
                .result(userResponse)
                .build();
    }

    @PostMapping("/upload-image")
    @Operation(
            summary = "Upload avatar",
            description = "Upload image file (JPEG, PNG) and return the image storage path on the server.",
            method = "POST"
    )
    public ApiResponse<String> uploadImage(@RequestParam("file") MultipartFile file) {
        try {
            String uploadDir = "upload/";
            String fileName = UUID.randomUUID() + "_" + file.getOriginalFilename();
            Path filePath = Paths.get(uploadDir + fileName);
            Files.createDirectories(filePath.getParent());
            Files.write(filePath, file.getBytes());

            return ApiResponse.success(filePath.toString());
        } catch (IOException e) {
            throw new RuntimeException("Failed to upload image", e);
        }
    }


}
