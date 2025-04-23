package com.example.FactoryManager.controller;

import com.example.FactoryManager.dto.request.CompanyRequest;
import com.example.FactoryManager.dto.response.ApiResponse;
import com.example.FactoryManager.dto.response.CompanyDropdownResponse;
import com.example.FactoryManager.dto.response.CompanyResponse;
import com.example.FactoryManager.service.CopanyService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.AccessLevel;
import lombok.experimental.FieldDefaults;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
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

    @GetMapping("/dropdown-list")
    @Operation(
            summary = "Get list dropdow of companies",
            description = "Returns a list of companies",
            method = "GET"
    )
    ApiResponse<List<CompanyDropdownResponse>> getCompaniesForDropdown() {
        log.info("Fetching all companies");
        List<CompanyDropdownResponse> companyResponses = companyService.getCompaniesForDropdown();
        return ApiResponse.<List<CompanyDropdownResponse>>builder()
                .code(200)
                .message("Success")
                .result(companyResponses)
                .build();
    }

    @GetMapping("/create")
    @Operation(
            summary = "Create a new company",
            description = "Creates a new company and returns the created company",
            method = "POST"
    )
    ApiResponse<CompanyResponse> createCompany(@Valid @RequestBody CompanyRequest companyRequest) {
        log.info("Creating a new company");
        CompanyResponse companyResponse = companyService.createCompany(companyRequest);
        return ApiResponse.<CompanyResponse>builder()
                .code(200)
                .message("Success")
                .result(companyResponse)
                .build();
    }

}
