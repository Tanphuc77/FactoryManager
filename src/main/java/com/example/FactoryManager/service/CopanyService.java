package com.example.FactoryManager.service;

import com.example.FactoryManager.dto.request.CompanyRequest;
import com.example.FactoryManager.dto.response.CompanyDropdownResponse;
import com.example.FactoryManager.dto.response.CompanyResponse;
import com.example.FactoryManager.entity.Company;
import com.example.FactoryManager.exception.AppException;
import com.example.FactoryManager.exception.ErrorCode;
import com.example.FactoryManager.mapper.CompanyMapper;
import com.example.FactoryManager.repository.CompanyRepository;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
@Slf4j
public class CopanyService {

    CompanyRepository companyRepository;
    CompanyMapper companyMapper;

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

}
