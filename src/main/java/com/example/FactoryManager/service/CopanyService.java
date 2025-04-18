package com.example.FactoryManager.service;

import com.example.FactoryManager.dto.response.CompanyResponse;
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

    public List<CompanyResponse> getAllCompanies(){
        var companies = companyRepository.findAll();

        return companies.stream().map(companyMapper::toCompanyResponse).toList();
    }

}
