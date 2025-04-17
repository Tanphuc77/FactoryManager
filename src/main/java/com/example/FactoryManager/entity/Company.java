package com.example.FactoryManager.entity;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;

import java.time.LocalDateTime;

@Entity
@Table(name = "company")
@Data
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Company {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    String id;

    @Column(nullable = false, length = 50)
    String code;

    @Column(name = "companyname", nullable = false, length = 100)
    String companyName;

    @Column(nullable = false)
    boolean subcontractor;

    @Column(nullable = false, length = 100)
    String state;

    @Column(nullable = false, length = 50)
    String status;

    @Column(nullable = false, length = 55)
    String contactName;

    @Column(length = 20)
    String mobilePhone;

    @Column(nullable = false, length = 200)
    String address;

    LocalDateTime createAt;
    LocalDateTime updateAt;
}
