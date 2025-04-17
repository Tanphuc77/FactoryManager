package com.example.FactoryManager.dto.request;

import com.example.FactoryManager.entity.Company;
import com.example.FactoryManager.entity.Role;
import com.example.FactoryManager.entity.Team;
import com.example.FactoryManager.enums.UserStatus;
import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;
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

    String firstname;

    String lastname;

    LocalDate dateOfBirth;

    @Enumerated(EnumType.STRING)
    UserStatus status;

    String username;

    String password;

    String image;

    Role role;

    Set<String> companyIds;
    Set<String> teamIds;
}
