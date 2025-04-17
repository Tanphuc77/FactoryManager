package com.example.FactoryManager.dto.request;

import com.example.FactoryManager.entity.Company;
import com.example.FactoryManager.entity.Role;
import com.example.FactoryManager.entity.Team;
import com.example.FactoryManager.enums.UserStatus;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Past;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.*;
import lombok.experimental.FieldDefaults;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.multipart.MultipartFile;

import java.time.LocalDate;
import java.util.Set;
import java.util.UUID;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class UserCreateRequest {

    @NotBlank(message = "This field is required")
    @Size(min = 3, max = 30)
    @Pattern(regexp = "^[a-zA-Z]+$", message = "ONLY_LETTER")
    String firstname;

    @NotBlank(message = "This field is required")
    @Size(min = 3, max = 30)
    @Pattern(regexp = "^[a-zA-Z]+$", message = "ONLY_LETTER")
    String lastname;

    @DateTimeFormat(pattern = "dd/MM/yyyy")
    @Past(message = "Date of birth must be in the past")
    private LocalDate dateOfBirth;

    @Enumerated(EnumType.STRING)
    UserStatus status;

    @NotBlank(message = "This field is required")
    @Pattern(regexp = "^[a-z0-9]{3,30}$", message = "USERNAME_INVALID")
    String username;

    @NotBlank
    @Pattern(regexp = "^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)(?=.*[^a-zA-Z0-9]).{8,}$",
            message = "PASSWORD_INVALID")
    String password;

    String image;

    Role role;

    Set<String> companyIds;
    Set<String> teamIds;
}
