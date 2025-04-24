package com.example.FactoryManager.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDateTime;

@Entity
@Table(name = "permission")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Permission {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int id;

    @Column(unique = true, nullable = false)
    String name;

    String description;

//    @ManyToOne
//    @JoinColumn(name = "group_id")
//    PermissionGroup group;

    @CreationTimestamp
    LocalDateTime createAt;

    @CreationTimestamp
    LocalDateTime updateAt;
}
