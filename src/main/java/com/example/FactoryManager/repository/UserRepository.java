package com.example.FactoryManager.repository;

import com.example.FactoryManager.dto.request.UserSearchRequest;
import com.example.FactoryManager.entity.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, String> {
    boolean existsUserByUsername(String username);

    Optional<User> findByUsername(String username);

    long countByRole_Name(String roleName);

    @Query("SELECT u FROM User u WHERE " +
            "(:#{#user.username} IS NULL OR u.username LIKE %:#{#user.username}%) AND " +
            "(:#{#user.firstname} IS NULL OR u.firstname LIKE %:#{#user.firstname}%) AND " +
            "(:#{#user.lastname} IS NULL OR u.lastname LIKE %:#{#user.lastname}%) AND " +
            "(:#{#user.role} IS NULL OR u.role.name LIKE %:#{#user.phoneNumber}%) AND " +
            "(:#{#user.status} IS NULL OR u.status = :#{#user.status})")
    Page<User> searchUser (@Param("user")UserSearchRequest user, Pageable pageable);

}
