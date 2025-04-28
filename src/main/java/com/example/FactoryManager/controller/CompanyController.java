package com.example.FactoryManager.controller;

import com.example.FactoryManager.dto.request.CompanyRequest;
import com.example.FactoryManager.dto.request.CompanySearchRequest;
import com.example.FactoryManager.dto.response.ApiResponse;
import com.example.FactoryManager.dto.response.CompanyDropdownResponse;
import com.example.FactoryManager.dto.response.CompanyResponse;
import com.example.FactoryManager.dto.response.PageResponse;
import com.example.FactoryManager.service.CopanyService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.AccessLevel;
import lombok.experimental.FieldDefaults;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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
            description = "Returns a paging list of companies",
            method = "GET"
    )
    ApiResponse<PageResponse<CompanyResponse>> getAllCompanies(
            @RequestParam(value = "page", defaultValue = "0") int page,
            @RequestParam(value = "size", defaultValue = "10") int size){
        log.info("Fetching all companies");
        PageResponse<CompanyResponse> pageResponse = companyService.getAllCompanies(page, size);
        return ApiResponse.<PageResponse<CompanyResponse>>builder()
                .code(200)
                .message("Success")
                .result(pageResponse)
                .build();
    }

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

    @GetMapping("/get/{id}")
    @Operation(
            summary = "Get company by ID",
            description = "Returns a company by ID",
            method = "GET"
    )
    ApiResponse<CompanyResponse> getCompanyById(@PathVariable String id) {
        log.info("Fetching company with ID: {}", id);
        CompanyResponse companyResponse = companyService.getCompanyById(id);
        return ApiResponse.<CompanyResponse>builder()
                .code(200)
                .message("Success")
                .result(companyResponse)
                .build();
    }

    @PostMapping("/create")
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

    @PutMapping("/update/{id}")
    @Operation(
            summary = "Update a company",
            description = "Updates an existing company and returns the updated company",
            method = "PUT"
    )
    ApiResponse<CompanyResponse> updateCompany(@PathVariable String id, @Valid @RequestBody CompanyRequest companyRequest) {
        log.info("Updating company with ID: {}", id);
        CompanyResponse companyResponse = companyService.updateCompany(id, companyRequest);
        return ApiResponse.<CompanyResponse>builder()
                .code(200)
                .message("Success")
                .result(companyResponse)
                .build();
    }

    @DeleteMapping("/delete/{id}")
    @Operation(
            summary = "Delete a company",
            description = "Deletes a company by ID",
            method = "DELETE"
    )
    ApiResponse<Void> deleteCompany(@PathVariable String id) {
        log.info("Deleting company with ID: {}", id);
        companyService.deleteCompany(id);
        return ApiResponse.<Void>builder()
                .code(200)
                .message("Success")
                .result(null)
                .build();
    }

    @GetMapping("search")
    @Operation(
            summary = "Search for companies",
            description = "Searches for companies based on the provided criteria",
            method = "GET"
    )
    ApiResponse <PageResponse<CompanyResponse>> searchCompany(
            @ModelAttribute CompanySearchRequest companySearchRequest,
            @RequestParam(value = "page", defaultValue = "0") int page,
            @RequestParam(value = "size", defaultValue = "10") int size) {
        log.info("Searching for companies with criteria: {}", companySearchRequest);
        PageResponse<CompanyResponse> pageResponse = companyService.searchCompany(companySearchRequest, page, size);
        return ApiResponse.<PageResponse<CompanyResponse>>builder()
                .code(200)
                .message("Success")
                .result(pageResponse)
                .build();
    }


}
