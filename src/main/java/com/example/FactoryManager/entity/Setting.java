package com.example.FactoryManager.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Map;

@Entity
@Table(name = "setting")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Setting {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "android_app_timeout")
    private Integer androidAppTimeout;

    @ElementCollection
    @MapKeyColumn(name = "level")
    @Column(name = "value")
    @CollectionTable(name = "difficulty_levels", joinColumns = @JoinColumn(name = "settings_id"))
    private Map<String, Double> difficultyLevels;

    @Column(name = "factory_jobs_refresh_time")
    private Integer factoryJobsRefreshTime;

    @Column(name = "factory_jobs_display_device")
    private String factoryJobsDisplayDevice;
}
