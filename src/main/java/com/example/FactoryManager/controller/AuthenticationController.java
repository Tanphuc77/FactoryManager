package com.example.FactoryManager.controller;

import com.example.FactoryManager.dto.request.AuthenticationRequest;
import com.example.FactoryManager.dto.request.IntrospectRequest;
import com.example.FactoryManager.dto.request.LogoutRequest;
import com.example.FactoryManager.dto.request.RefreshRequest;
import com.example.FactoryManager.dto.response.ApiResponse;
import com.example.FactoryManager.dto.response.AuthenticationResponse;
import com.example.FactoryManager.dto.response.IntrospectResponse;
import com.example.FactoryManager.service.AuthenticationService;
import com.nimbusds.jose.JOSEException;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.text.ParseException;

import static lombok.AccessLevel.PRIVATE;

@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor
@Slf4j
@FieldDefaults(level = PRIVATE, makeFinal = true)
@Tag(name = "Authentication Controller")
public class AuthenticationController {

    AuthenticationService authenticationService;

    @PostMapping("/login")
    @Operation(
            method = "POST",
            summary = "Login",
            description = "Authenticate user and generate JWT"
    )
    ApiResponse<AuthenticationResponse> authenticate(@Valid @RequestBody AuthenticationRequest request) {
        log.info("Authenticating user: {}", request.getUsername());
        var result = authenticationService.authenticate(request);
        return ApiResponse.<AuthenticationResponse>builder()
                .result(result)
                .build();
    }

    @PostMapping("/introspect")
    @Operation(
            method = "POST",
            summary = "Introspect Token",
            description = "This endpoint allows you to check the validity of a token"
    )
    ApiResponse<IntrospectResponse> introspect(@RequestBody IntrospectRequest request) throws ParseException, JOSEException {
        var result = authenticationService.introspect(request);
        return ApiResponse.<IntrospectResponse>builder()
                .result(result)
                .build();
    }

    @PostMapping("/logout")
    @Operation(
            method = "POST",
            summary = "Logout",
            description = "This endpoint allows you to logout a user"
    )
    ApiResponse<Void> logout(@RequestBody LogoutRequest request) throws ParseException, JOSEException {
        authenticationService.logout(request);
        return ApiResponse.<Void>builder()
                .result(null)
                .build();
    }

    @PostMapping("/refresh")
    @Operation(
            method = "POST",
            summary = "Refresh Token",
            description = "This endpoint allows you to refresh your JWT token"
    )
    ApiResponse<AuthenticationResponse> refresh(@RequestBody RefreshRequest request) throws ParseException, JOSEException {
        var result = authenticationService.refreshToken(request);
        return ApiResponse.<AuthenticationResponse>builder()
                .result(result)
                .build();
    }
}
