package com.example.FactoryManager.service;

import com.example.FactoryManager.constant.PredefinedRole;
import com.example.FactoryManager.dto.request.UserCreateRequest;
import com.example.FactoryManager.dto.response.PageResponse;
import com.example.FactoryManager.dto.response.UserResponse;
import com.example.FactoryManager.entity.Company;
import com.example.FactoryManager.entity.Role;
import com.example.FactoryManager.entity.Team;
import com.example.FactoryManager.entity.User;
import com.example.FactoryManager.exception.AppException;
import com.example.FactoryManager.exception.ErrorCode;
import com.example.FactoryManager.mapper.UserMapper;
import com.example.FactoryManager.repository.CompanyRepository;
import com.example.FactoryManager.repository.RoleRepository;
import com.example.FactoryManager.repository.TeamRepository;
import com.example.FactoryManager.repository.UserRepository;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
@Slf4j
public class UserService {

    UserRepository userRepository;
    UserMapper userMapper;
    PasswordEncoder passwordEncoder;
    CompanyRepository companyRepository;
    TeamRepository teamRepository;
    RoleRepository roleRepository;

    @PreAuthorize("hasAnyRole('ADMIN', 'SUPER_ADMIN')")
    public PageResponse<UserResponse> getAllUsers(int page, int size) {
        Pageable pageable = PageRequest.of(page, size);

        Page<User> userPage = userRepository.findAll(pageable);

        // Chỉ giữ lại những user KHÔNG có vai trò là SUPER_ADMIN
        List<User> filteredUsers = new ArrayList<>();
        for (User user : userPage.getContent()) {
            Role role = user.getRole();
            if (role != null && !role.getName().equalsIgnoreCase("SUPER_ADMIN")) {
                filteredUsers.add(user);
            }
        }

        List<UserResponse> userResponseList = new ArrayList<>();
        for (User user : filteredUsers) {
            UserResponse userResponse = userMapper.toUserResponse(user);
            userResponseList.add(userResponse);
        }

        PageResponse<UserResponse> response = PageResponse.<UserResponse>builder()
                .content(userResponseList)
                .currentPage(userPage.getNumber())
                .totalPages(userPage.getTotalPages())
                .totalElements(userPage.getTotalElements())
                .build();

        return response;
    }

    public UserResponse createUser(UserCreateRequest request) {
        if (userRepository.existsUserByUsername(request.getUsername())) {
            throw new AppException(ErrorCode.USERNAME_ALREADY_EXISTS);
        }

        User user = userMapper.toUser(request);
        user.setPassword(passwordEncoder.encode(user.getPassword()));

        Role role = roleRepository.findById(Integer.toString(request.getRole().getId()))
                .orElseThrow(() -> new AppException(ErrorCode.ROLE_NOT_FOUND));

        // KHÔNG CHO GÁN VAI TRÒ SUPER ADMIN
        if (PredefinedRole.SUPER_ADMIN_ROLE.equalsIgnoreCase(role.getName())) {
            throw new AppException(ErrorCode.ROLE_NOT_ALLOWED);
        }
        user.setRole(role);

        Set<Company> companies = request.getCompanyIds().stream()
                .map(id -> companyRepository.findById(id)
                        .orElseThrow(() -> new AppException(ErrorCode.COMPANY_NOT_FOUND)))
                .collect(Collectors.toSet());
        user.setCompany(new HashSet<>(companies));

        Set<Team> teams = request.getTeamIds().stream()
                .map(id -> teamRepository.findById(id)
                        .orElseThrow(() -> new AppException(ErrorCode.TEAM_NOT_FOUND)))
                .collect(Collectors.toSet());
        user.setTeam(new HashSet<>(teams));

        // Save user
        User saved = userRepository.save(user);
        return userMapper.toUserResponse(saved);
    }


}
