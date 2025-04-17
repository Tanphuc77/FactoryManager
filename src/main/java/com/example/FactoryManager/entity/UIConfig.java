package com.example.FactoryManager.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Entity
@Table(name = "ui_config")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class UIConfig {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int id;

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    User user;

    @Column(name = "screen_code", nullable = false, length = 100)
    String screenCode;

    @Column(name = "config_json", nullable = false, columnDefinition = "TEXT")
    String configJson;

    LocalDateTime createdAt;
    LocalDateTime updatedAt;
}
