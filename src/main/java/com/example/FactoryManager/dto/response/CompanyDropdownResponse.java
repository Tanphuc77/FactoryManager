package com.example.FactoryManager.dto.response;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.Data;
import lombok.experimental.FieldDefaults;

@Data
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
public class CompanyDropdownResponse {

    String companyId;

    String code;

    String companyName;
}