package com.example.FactoryManager.service;

import com.example.FactoryManager.configuration.SecurityUtil;
import com.example.FactoryManager.constant.PredefinedRole;
import com.example.FactoryManager.dto.request.ChangePasswordRequest;
import com.example.FactoryManager.dto.request.UserCreateRequest;
import com.example.FactoryManager.dto.request.UserSearchRequest;
import com.example.FactoryManager.dto.request.UserUpdateRequest;
import com.example.FactoryManager.dto.response.PageResponse;
import com.example.FactoryManager.dto.response.UserDetailResponse;
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
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
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

    @PreAuthorize("hasAuthority('VIEW_LIST_USER')")
    public PageResponse<UserResponse> getAllUsers(int page, int size) {
        Pageable pageable = PageRequest.of(page, size);
        Page<User> userPage = userRepository.findAll(pageable);

        List<UserResponse> userResponses = new ArrayList<>();
        for (User user : userPage.getContent()) {
            UserResponse userResponse = userMapper.toUserResponse(user);
            userResponses.add(userResponse);
        }

        PageResponse<UserResponse> response = PageResponse.<UserResponse>builder()
                .content(userResponses)
                .currentPage(userPage.getNumber())
                .totalPages(userPage.getTotalPages())
                .totalElements(userPage.getTotalElements())
                .build();

        return response;
    }

    @PreAuthorize("hasAuthority('VIEW_LIST_USER')")
    public UserDetailResponse getUserById(String id) {
        User user = userRepository.findById(id)
                .orElseThrow(() -> new AppException(ErrorCode.USER_NOT_FOUND));

        UserDetailResponse userDetailResponse = userMapper.toUserDetailResponse(user);
        return userDetailResponse;
    }

    public UserResponse getMyInfo() {
        var context = SecurityContextHolder.getContext();
        String name = context.getAuthentication().getName();

        User user = userRepository.findByUsername(name)
                .orElseThrow(() -> new AppException(ErrorCode.USER_NOT_FOUND));

        return userMapper.toUserResponse(user);
    }

    @PreAuthorize("hasAuthority('ADD_USER')")
    public UserResponse createUser(UserCreateRequest request) {
        SecurityUtil.checkForbiddenAdminToModify(request.getRole().getName());

        if (userRepository.existsUserByUsername(request.getUsername())) {
            throw new AppException(ErrorCode.USERNAME_ALREADY_EXISTS);
        }

        User user = userMapper.toUser(request);
        user.setPassword(passwordEncoder.encode(user.getPassword()));

        Role role = roleRepository.findById(request.getRole().getId())
                .orElseThrow(() -> new AppException(ErrorCode.ROLE_NOT_FOUND));

        if (PredefinedRole.SUPER_ADMIN_ROLE.equalsIgnoreCase(role.getName())) {
            throw new AppException(ErrorCode.ROLE_NOT_ALLOWED);
        }
        user.setRole(role);

        Set<Company> companies = mapCompanyIdsToEntities(request.getCompanyIds());
        user.setCompany(companies);

        Set<Team> teams = mapTeamIdsToEntities(request.getTeamIds());
        user.setTeam(teams);


        // Save user
        return userMapper.toUserResponse(userRepository.save(user));
    }

    @PreAuthorize("hasAuthority('EDIT_USER')")
    public UserResponse updateUser(String userId, UserUpdateRequest userUpdateRequest) {
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new AppException(ErrorCode.USER_NOT_FOUND));

        if (userUpdateRequest.getUsername() != null && !userUpdateRequest.getUsername().equals(user.getUsername())) {
            if (userRepository.existsUserByUsername(userUpdateRequest.getUsername())) {
                throw new AppException(ErrorCode.USERNAME_ALREADY_EXISTS);
            }
            user.setUsername(userUpdateRequest.getUsername());
        }

        // Fetch role by roleId and validate
        Role role = roleRepository.findById(userUpdateRequest.getRoleId())
                .orElseThrow(() -> new AppException(ErrorCode.ROLE_NOT_FOUND));

        SecurityUtil.checkForbiddenAdminToModify(role.getName());
        SecurityUtil.checkForbiddenSuperAdminToModifySelf(userUpdateRequest.getUsername());

        if (PredefinedRole.SUPER_ADMIN_ROLE.equalsIgnoreCase(role.getName())) {
            throw new AppException(ErrorCode.ROLE_NOT_ALLOWED);
        }

        user.setRole(role);

        Set<Company> companies = mapCompanyIdsToEntities(userUpdateRequest.getCompanyIds());
        user.setCompany(companies);

        Set<Team> teams = mapTeamIdsToEntities(userUpdateRequest.getTeamIds());
        user.setTeam(teams);

        userMapper.updateUser(user, userUpdateRequest);
        UserResponse userResponse = userMapper.toUserResponse(userRepository.save(user));

        return userResponse;
    }

    @PreAuthorize("hasAuthority('DELETE_USER')")
    public void deleteUser(String userId) {
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new AppException(ErrorCode.USER_NOT_FOUND));

        SecurityUtil.checkForbiddenAdminToModify(user.getRole().getName());
        SecurityUtil.checkForbiddenSuperAdminToModifySelf(user.getUsername());

        if (PredefinedRole.SUPER_ADMIN_ROLE.equalsIgnoreCase(user.getRole().getName())) {
            throw new AppException(ErrorCode.ROLE_NOT_ALLOWED);
        }

        userRepository.delete(user);
    }

    @PreAuthorize("hasAuthority('CHANGE_PASSWORD')")
    public void changePasswordForUser(String userId,ChangePasswordRequest changePasswordRequest){
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new AppException(ErrorCode.USER_NOT_FOUND));

        SecurityUtil.checkForbiddenAdminToModify(user.getRole().getName());
        SecurityUtil.checkForbiddenSuperAdminToModifySelf(user.getUsername());

        user.setPassword(passwordEncoder.encode(changePasswordRequest.getPassword()));
        userRepository.save(user);
    }

    @PreAuthorize("hasAuthority('SEARCH_USER')")
    public PageResponse<UserResponse> searchUser(UserSearchRequest userSearchRequest,int page,int size){
        Pageable pageable = PageRequest.of(page, size);
        Page<User> userPage = userRepository.searchUser(
                userSearchRequest,
                pageable
        );
        List<UserResponse> userResponseList = userPage.getContent().stream()
                .map(userMapper::toUserResponse)
                .collect(Collectors.toList());

        return PageResponse.<UserResponse>builder()
                .content(userResponseList)
                .currentPage(userPage.getNumber())
                .totalPages(userPage.getTotalPages())
                .totalElements(userPage.getTotalElements())
                .build();
    }

    private Set<Company> mapCompanyIdsToEntities(Set<String> companyIds) {
        if (companyIds == null) return Collections.emptySet();

        return companyIds.stream()
                .map(id -> companyRepository.findById(id)
                        .orElseThrow(() -> new AppException(ErrorCode.COMPANY_NOT_FOUND)))
                .collect(Collectors.toSet());
    }

    private Set<Team> mapTeamIdsToEntities(Set<String> teamIds) {
        if (teamIds == null) return Collections.emptySet();

        return teamIds.stream()
                .map(id -> teamRepository.findById(id)
                        .orElseThrow(() -> new AppException(ErrorCode.TEAM_NOT_FOUND)))
                .collect(Collectors.toSet());
    }

}
