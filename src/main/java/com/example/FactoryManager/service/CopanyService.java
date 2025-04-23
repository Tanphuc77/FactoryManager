package com.example.FactoryManager.service;

import com.example.FactoryManager.dto.request.CompanyRequest;
import com.example.FactoryManager.dto.response.CompanyDropdownResponse;
import com.example.FactoryManager.dto.response.CompanyResponse;
import com.example.FactoryManager.dto.response.PageResponse;
import com.example.FactoryManager.entity.Company;
import com.example.FactoryManager.exception.AppException;
import com.example.FactoryManager.exception.ErrorCode;
import com.example.FactoryManager.mapper.CompanyMapper;
import com.example.FactoryManager.repository.CompanyRepository;
import io.swagger.v3.oas.models.media.Content;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
@Slf4j
public class CopanyService {

    CompanyRepository companyRepository;
    CompanyMapper companyMapper;


    public PageResponse<CompanyResponse> getAllCompanies(int page, int size){
        Pageable pageable = PageRequest.of(page, size);
        Page<Company> companyPage = companyRepository.findAll(pageable);

        List<CompanyResponse> companyResponses = new ArrayList<>();
        for(Company company : companyPage.getContent()){
            CompanyResponse companyResponse = companyMapper.toCompanyResponse(company);
            companyResponses.add(companyResponse);
        }

        PageResponse<CompanyResponse> pageResponse = PageResponse.<CompanyResponse>builder()
                .content(companyResponses)
                .currentPage(companyPage.getNumber())
                .totalPages(companyPage.getTotalPages())
                .totalElements(companyPage.getTotalElements())
                .build();

        return pageResponse;

    }

    public List<CompanyDropdownResponse> getCompaniesForDropdown(){
        var companies = companyRepository.findAll();

        return companies.stream().map(companyMapper::toCompanyDropdownResponse).toList();
    }

    public CompanyResponse createCompany(CompanyRequest companyRequest){
        if(companyRepository.existsByCode(companyRequest.getCode())){
            throw new AppException(ErrorCode.CODE_COMPANY_EXISTS);
        }

        Company company = companyMapper.toCompany(companyRequest);
        return companyMapper.toCompanyResponse(companyRepository.save(company));
    }

    public CompanyResponse updateCompany(String id, CompanyRequest companyRequest){
        Company company = companyRepository.findById(id)
                .orElseThrow(() -> new AppException(ErrorCode.COMPANY_NOT_FOUND));


        if(companyRequest.getCode() != null && !company.getCode().equals(companyRequest.getCode())){
            if(companyRepository.existsByCode(companyRequest.getCode())){
                throw new AppException(ErrorCode.CODE_COMPANY_EXISTS);
            }
            company.setCode(companyRequest.getCode());
        }

        companyMapper.updateCompany(company, companyRequest);
        return companyMapper.toCompanyResponse(companyRepository.save(company));

    }

    public void deleteCompany(String id){
        Company company = companyRepository.findById(id)
                .orElseThrow(() -> new AppException(ErrorCode.COMPANY_NOT_FOUND));

        companyRepository.delete(company);
    }




}
