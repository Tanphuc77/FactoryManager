package com.example.FactoryManager.repository;

import com.example.FactoryManager.entity.Setting;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SettingRepository extends JpaRepository<Setting, Long> {
}
