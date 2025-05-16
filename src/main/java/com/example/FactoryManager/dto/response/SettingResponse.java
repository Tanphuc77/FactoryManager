package com.example.FactoryManager.dto.response;

import lombok.*;
import lombok.experimental.FieldDefaults;

import java.util.Map;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
public class SettingResponse {

    Long settingId;
    Integer androidAppTimeout;
    Map<String, Double> difficultyLevels;
    Integer factoryJobsRefreshTime;
    String factoryJobsDisplayDevice;
}
