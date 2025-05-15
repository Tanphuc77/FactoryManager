package com.example.FactoryManager.service;

import com.example.FactoryManager.dto.request.RolePermissionCreateRequest;
import com.example.FactoryManager.dto.request.RolePermissionRequest;
import com.example.FactoryManager.dto.response.RolePermissionResponse;
import com.example.FactoryManager.dto.response.RoleResponse;
import com.example.FactoryManager.entity.Permission;
import com.example.FactoryManager.entity.Role;
import com.example.FactoryManager.exception.AppException;
import com.example.FactoryManager.exception.ErrorCode;
import com.example.FactoryManager.mapper.RoleMapper;
import com.example.FactoryManager.repository.PermissionRepository;
import com.example.FactoryManager.repository.RoleRepository;
import jakarta.transaction.Transactional;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
@Slf4j
public class RoleService {

    RoleRepository roleRepository;

    RoleMapper roleMapper;

    PermissionRepository permissionRepository;

    public List<RoleResponse> getAllRoles(){
        var roles = roleRepository.findAll();
        return roles.stream()
                .map(roleMapper::toRoleResponse).toList();
    }

    public List<RolePermissionResponse> getAllRolesWithPermissions() {
        var roles = roleRepository.findAll();
        return roles.stream()
                .map(roleMapper::toRolePermissionResponse)
                .toList();
    }

    public RolePermissionResponse getRoleById(int roleId){
        Role role = roleRepository.findById(roleId)
                .orElseThrow(() -> new AppException(ErrorCode.ROLE_NOT_FOUND));

        return roleMapper.toRolePermissionResponse(role);
    }

    @Transactional
    public void assignPermissionsToRole(int roleId ,RolePermissionRequest rolePermissionRequest){
        Role role = roleRepository.findById(roleId)
                .orElseThrow(() -> new AppException(ErrorCode.ROLE_NOT_FOUND));

        Set<Permission> permissions = permissionRepository.findByIdIn(rolePermissionRequest.getPermissionIds());

        if(permissions.size() != rolePermissionRequest.getPermissionIds().size()){
            throw new AppException(ErrorCode.PERMISSION_NOT_FOUND);
        }

        role.getPermission().clear();
        role.getPermission().addAll(permissions);

        roleRepository.save(role);

    }

    @Transactional
    public RolePermissionResponse createRole(RolePermissionCreateRequest request) {
        if (roleRepository.existsByName(request.getName())) {
            throw new AppException(ErrorCode.ROLE_ALREADY_EXISTS);
        }

        if (request.getPermissionIds() == null || request.getPermissionIds().isEmpty()) {
            throw new AppException(ErrorCode.INVALID_INPUT);
        }

        // Chuyển đổi DTO thành entity
        Role role = roleMapper.toRolePermission(request);
        Set<Permission> permissions = permissionRepository.findByIdIn(request.getPermissionIds());

        // Kiểm tra quyền hợp lệ
        Set<Integer> foundPermissionIds = permissions.stream()
                .map(Permission::getId)
                .collect(Collectors.toSet());
        Set<Integer> missingIds = request.getPermissionIds().stream()
                .filter(id -> !foundPermissionIds.contains(id))
                .collect(Collectors.toSet());
        if (!missingIds.isEmpty()) {
            throw new AppException(ErrorCode.PERMISSION_NOT_FOUND);
        }

        role.setPermission(permissions);

        return roleMapper.toRolePermissionResponse(roleRepository.save(role));
    }
}
