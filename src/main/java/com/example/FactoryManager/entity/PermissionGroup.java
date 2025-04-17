//package com.example.FactoryManager.entity;
//
//import jakarta.persistence.*;
//import lombok.AllArgsConstructor;
//import lombok.Data;
//import lombok.NoArgsConstructor;
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
//    LocalDateTime createAt;
//    LocalDateTime updateAt;
//
//    @OneToMany(mappedBy = "group", fetch = FetchType.EAGER)
//    Set<Permission> permissions;
//}
