package com.example.FactoryManager.dto.request;

import com.example.FactoryManager.entity.Role;
import com.example.FactoryManager.enums.UserStatus;
import com.example.FactoryManager.validator.DobConstraint;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Past;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.*;
import lombok.experimental.FieldDefaults;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;
import java.util.Set;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class UserUpdateRequest {

    @NotBlank(message = "This field is required")
    @Size(min = 3, max = 30)
    @Pattern(regexp = "^[a-zA-Z]+$", message = "ONLY_LETTER")
    String firstname;

    @NotBlank(message = "This field is required")
    @Size(min = 3, max = 30)
    @Pattern(regexp = "^[a-zA-Z]+$", message = "ONLY_LETTER")
    String lastname;

    @DateTimeFormat(pattern = "dd/MM/yyyy")
    @DobConstraint(min = 10, message = "INVALID_DOB")
    private LocalDate dateOfBirth;

    @Enumerated(EnumType.STRING)
    UserStatus status;

    @NotBlank(message = "This field is required")
    @Pattern(regexp = "^[a-z0-9]{3,30}$", message = "USERNAME_INVALID")
    String username;

    String image;

    //@JsonIgnoreProperties({"name","description", "createAt", "updateAt", "users", "permission"})
    Integer roleId;

    Set<String> companyIds;
    Set<String> teamIds;
}
