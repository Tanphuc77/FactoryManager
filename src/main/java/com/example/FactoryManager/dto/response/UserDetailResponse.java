package com.example.FactoryManager.dto.response;

import com.example.FactoryManager.entity.Company;
import com.example.FactoryManager.entity.Team;
import com.example.FactoryManager.enums.UserStatus;
import com.fasterxml.jackson.annotation.JsonInclude;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Data;
import lombok.experimental.FieldDefaults;

import java.time.LocalDate;
import java.util.Set;

@Data
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class UserDetailResponse {

    String userId;

    String image;

    String username;

    String firstname;

    String lastname;

    LocalDate dateOfBirth;

    String roleName;

    @Enumerated(EnumType.STRING)
    UserStatus status;

    boolean projectManager;

    Set<Company> company;

    Set<Team> team;
}
