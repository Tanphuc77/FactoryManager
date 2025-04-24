package com.example.FactoryManager.dto.request;

import com.example.FactoryManager.enums.CompanyStatus;
import com.example.FactoryManager.enums.UserStatus;
import lombok.*;
import lombok.experimental.FieldDefaults;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
public class CompanySearchRequest {
    String keyword;
    String state;
    CompanyStatus status;
}
