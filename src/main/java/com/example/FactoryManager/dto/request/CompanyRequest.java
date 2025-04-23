package com.example.FactoryManager.dto.request;

import com.example.FactoryManager.enums.CompanyStatus;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.time.LocalDateTime;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class CompanyRequest {

    @NotBlank(message = "Company ID is required")
    @Size(max =10, message = "COMPANY_CODE_REQUIRED")
    String code;

    @NotBlank(message = "Company name is required")
    @Size(max = 100, message = "COMPANY_NAME_REQUIRED")
    String companyName;

    boolean subcontractor;

    @NotBlank(message = "State is required")
    String state;

    @NotBlank(message = "Status is required")
    CompanyStatus status;

    @NotBlank(message = "Contact name is required")
    @Size(max = 50, message = "CONTACT_NAME_REQUIRED")
    String contactName;

    @NotBlank(message = "Mobile phone is required")
    @Pattern(regexp = "^\\+?[0-9]{10,15}$", message = "MOBILE_PHONE_INVALID")
    String mobilePhone;

    @NotBlank(message = "Address is required")
    String address;

}


