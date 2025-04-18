package com.example.FactoryManager.service;

import com.example.FactoryManager.dto.response.RoleResponse;
import com.example.FactoryManager.mapper.RoleMapper;
import com.example.FactoryManager.repository.RoleRepository;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
@Slf4j
public class RoleService {

    RoleRepository roleRepository;

    RoleMapper roleMapper;

    public List<RoleResponse> getAllRoles(){
        var roles = roleRepository.findAll();
        return roles.stream()
                .map(roleMapper::toRoleResponse).toList();
    }
}
