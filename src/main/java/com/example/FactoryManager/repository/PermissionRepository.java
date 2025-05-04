package com.example.FactoryManager.repository;

import com.example.FactoryManager.entity.Permission;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Set;

@Repository
public interface PermissionRepository extends JpaRepository<Permission, Integer> {
    Set<Permission> findByIdIn(Set<Integer> ids);
}
