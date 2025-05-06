package com.example.FactoryManager.repository;

import com.example.FactoryManager.entity.UIConfig;
import com.example.FactoryManager.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UIConfigRepository extends JpaRepository<UIConfig, Integer> {

    Optional<UIConfig> findByUserAndScreenCode(User user, String screenCode);
}
