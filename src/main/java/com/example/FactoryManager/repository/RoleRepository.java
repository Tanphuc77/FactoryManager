package com.example.FactoryManager.repository;

import com.example.FactoryManager.entity.Role;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface RoleRepository extends JpaRepository<Role, Integer> {
    boolean existsRoleByName(String name);
    Optional<Role> findByName(String name);

    Optional<Role> findById(Integer id);
}
