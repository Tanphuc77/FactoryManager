package com.example.FactoryManager.dto.response;

import jakarta.persistence.Column;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Data;
import lombok.experimental.FieldDefaults;

@Data
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
public class CompanyResponse {

    String companyId;

    String code;

    String companyName;

    boolean subcontractor;

    String state;

    String status;

    String contactName;

    String mobilePhone;

    String address;
}
