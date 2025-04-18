package com.example.FactoryManager.controller;

import com.example.FactoryManager.dto.response.ApiResponse;
import com.example.FactoryManager.dto.response.CompanyResponse;
import com.example.FactoryManager.service.CopanyService;
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
@RequestMapping("/companys")
@Slf4j
@FieldDefaults(level = AccessLevel.PRIVATE)
@Tag(name = "Company Controller")
public class CompanyController {

    @Autowired
    CopanyService companyService;

    @GetMapping("/get")
    @Operation(
            summary = "Get list of companies",
            description = "Returns a list of companies",
            method = "GET"
    )
    ApiResponse<List<CompanyResponse>> getAllCompanies() {
        log.info("Fetching all companies");
        List<CompanyResponse> companyResponses = companyService.getAllCompanies();
        return ApiResponse.<List<CompanyResponse>>builder()
                .code(200)
                .message("Success")
                .result(companyResponses)
                .build();
    }

}
