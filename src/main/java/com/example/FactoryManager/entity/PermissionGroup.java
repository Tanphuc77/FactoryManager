//package com.example.FactoryManager.entity;
//
//import jakarta.persistence.*;
//import lombok.AllArgsConstructor;
//import lombok.Data;
//import lombok.NoArgsConstructor;
//import org.hibernate.annotations.CreationTimestamp;
//
//import java.time.LocalDateTime;
//import java.util.Set;
//
//@Entity
//@Table(name = "permission_group")
//@Data
//@NoArgsConstructor
//@AllArgsConstructor
//public class PermissionGroup {
//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    int id;
//
//    @Column(unique = true, nullable = false)
//    String name;
//
//    String description;
//
//    @CreationTimestamp
//    LocalDateTime createAt;
//
//    @CreationTimestamp
//    LocalDateTime updateAt;
//
//    @OneToMany(mappedBy = "group", fetch = FetchType.LAZY)
//    Set<Permission> permissions;
//}
