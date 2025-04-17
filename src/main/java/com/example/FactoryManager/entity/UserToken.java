package com.example.FactoryManager.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Entity
@Builder
@Table(name = "user_token")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserToken {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    String id;

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    User user;

    @Column(columnDefinition = "TEXT", nullable = false)
    String token;

    @Column(name = "token_type", nullable = false)
    String tokenType;

    @Column(name = "device_info")
    String deviceInfo;

    LocalDateTime issuedAt;
    LocalDateTime expiryAt;

    @Column(nullable = false)
    boolean isValid;

    LocalDateTime createdAt;
    LocalDateTime updatedAt;
}
