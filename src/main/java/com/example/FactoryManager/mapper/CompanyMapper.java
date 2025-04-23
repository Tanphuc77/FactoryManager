package com.example.FactoryManager.mapper;

import com.example.FactoryManager.dto.request.CompanyRequest;
import com.example.FactoryManager.dto.response.CompanyDropdownResponse;
import com.example.FactoryManager.dto.response.CompanyResponse;
import com.example.FactoryManager.entity.Company;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

@Mapper(componentModel = "spring")
public interface CompanyMapper {

    Company toCompany(CompanyRequest companyRequest);

    @Mapping(source = "id", target = "companyId")
    CompanyDropdownResponse toCompanyDropdownResponse(Company company);

    @Mapping(source = "id", target = "companyId")
    CompanyResponse toCompanyResponse(Company company);

    @Mapping(target = "id", ignore = true)
    void updateCompany(@MappingTarget Company company, CompanyRequest companyRequest);
}
