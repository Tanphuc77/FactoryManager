package com.example.FactoryManager.service;

import com.example.FactoryManager.dto.request.UIConfigRequest;
import com.example.FactoryManager.dto.response.UIConfigResponse;
import com.example.FactoryManager.entity.UIConfig;
import com.example.FactoryManager.entity.User;
import com.example.FactoryManager.exception.AppException;
import com.example.FactoryManager.exception.ErrorCode;
import com.example.FactoryManager.mapper.UIMapper;
import com.example.FactoryManager.repository.UIConfigRepository;
import com.example.FactoryManager.repository.UserRepository;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
@Slf4j
public class UIConfigService {

    UIConfigRepository uiConfigRepository;

    UserRepository userRepository;

    UIMapper uiMapper;

    public UIConfigResponse saveUIConfig(UIConfigRequest uiConfigRequest) {
        User user = userRepository.findById(uiConfigRequest.getUserId())
                .orElseThrow(() -> new AppException(ErrorCode.USER_NOT_FOUND));

        String normalizedScreenCode = uiConfigRequest.getScreenCode() != null
                ? uiConfigRequest.getScreenCode().trim().toUpperCase().replaceAll("\\s+", "_")
                : "ITEM_MANAGEMENT";

        UIConfig uiConfig = uiMapper.toUIConfig(uiConfigRequest);
        uiConfig.setUser(user);
        uiConfig.setScreenCode(normalizedScreenCode);

        UIConfig existingUIConfig = uiConfigRepository.findByUserAndScreenCode(user, normalizedScreenCode)
                .orElse(null);

        if (existingUIConfig != null) {
            existingUIConfig.setConfigJson(uiConfig.getConfigJson());
            uiConfigRepository.save(existingUIConfig);
            return uiMapper.toUIConfigResponse(existingUIConfig);
        } else {
            uiConfigRepository.save(uiConfig);
            return uiMapper.toUIConfigResponse(uiConfig);
        }
    }

    public UIConfigResponse getUserCurrentUIConfig(User user, String screenCode) {
        log.info("Fetching UI config for userId: {}, screenCode: {}", user.getId(), screenCode);

        String normalizedScreenCode = screenCode != null
                ? screenCode.trim().toUpperCase().replaceAll("\\s+", "_")
                : "ITEM_MANAGEMENT";
        UIConfig uiConfig = uiConfigRepository.findByUserAndScreenCode(user, normalizedScreenCode)
                .orElseThrow(() -> new AppException(ErrorCode.UI_CONFIG_NOT_FOUND));
        return uiMapper.toUIConfigResponse(uiConfig);
    }

    public User loadUserById(String username) {
        return userRepository.findByUsername(username)
                .orElseThrow(() -> new AppException(ErrorCode.USER_NOT_FOUND));
    }

}
