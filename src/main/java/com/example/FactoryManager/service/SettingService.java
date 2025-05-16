package com.example.FactoryManager.service;

import com.example.FactoryManager.dto.request.SettingRequest;
import com.example.FactoryManager.dto.response.SettingResponse;
import com.example.FactoryManager.entity.Setting;
import com.example.FactoryManager.exception.AppException;
import com.example.FactoryManager.exception.ErrorCode;
import com.example.FactoryManager.mapper.SettingMapper;
import com.example.FactoryManager.repository.SettingRepository;
import jakarta.transaction.Transactional;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
@Slf4j
public class SettingService {

    SettingRepository settingRepository;

    SettingMapper settingMapper;


    public SettingResponse getAllSettings() {
        Setting setting = settingRepository.findAll().get(0);
        return settingMapper.toSettingsResponse(setting);
    }

    public SettingResponse getSetting(Long id) {
        Setting setting = settingRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Settings not found with id: " + id));
        return settingMapper.toSettingsResponse(setting);
    }

    @Transactional
    public SettingResponse updateSetting(Long id, SettingRequest request) {
        // Kiểm tra dữ liệu đầu vào (giữ nguyên như trước)
        if (request.getAndroidAppTimeout() == null || request.getAndroidAppTimeout() <= 0) {
            throw new IllegalArgumentException("Android App Timeout must be greater than 0");
        }
        if (request.getFactoryJobsRefreshTime() == null || request.getFactoryJobsRefreshTime() <= 0) {
            throw new IllegalArgumentException("Factory Jobs Refresh Time must be greater than 0");
        }
        if (request.getFactoryJobsDisplayDevice() == null || request.getFactoryJobsDisplayDevice().isEmpty()) {
            throw new IllegalArgumentException("Factory Jobs Display Device cannot be empty");
        }
        if (request.getDifficultyLevels() == null || request.getDifficultyLevels().isEmpty()) {
            throw new IllegalArgumentException("Difficulty Levels cannot be empty");
        }

        // Tìm bản ghi theo id
        Setting setting = settingRepository.findById(id)
                .orElseThrow(() -> new AppException(ErrorCode.SETTING_NOT_FOUND));

        settingMapper.updateSetting(setting, request);
        SettingResponse settingResponse = settingMapper.toSettingsResponse(settingRepository.save(setting));

        return settingResponse;

    }
}
