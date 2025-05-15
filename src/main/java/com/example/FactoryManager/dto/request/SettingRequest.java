package com.example.FactoryManager.dto.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Map;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class SettingRequest {

    private Integer androidAppTimeout;
    private Map<String, Double> difficultyLevels;
    private Integer factoryJobsRefreshTime;
    private String factoryJobsDisplayDevice;
}
