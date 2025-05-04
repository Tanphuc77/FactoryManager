package com.example.FactoryManager.service;

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

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

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

    public RoleResponse getRoleById(int roleId){
        Role role = roleRepository.findById(roleId)
                .orElseThrow(() -> new AppException(ErrorCode.ROLE_NOT_FOUND));
        return roleMapper.toRoleResponse(role);
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
}
