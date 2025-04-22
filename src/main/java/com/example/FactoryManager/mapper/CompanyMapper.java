package com.example.FactoryManager.mapper;

import com.example.FactoryManager.dto.response.CompanyResponse;
import com.example.FactoryManager.entity.Company;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface CompanyMapper {

    @Mapping(source = "id", target = "companyId")
    CompanyResponse toCompanyResponse(Company company);
}
