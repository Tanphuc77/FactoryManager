package com.example.FactoryManager.mapper;

import com.example.FactoryManager.dto.response.CompanyResponse;
import com.example.FactoryManager.entity.Company;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface CompanyMapper {

    CompanyResponse toCompanyResponse(Company company);
}
