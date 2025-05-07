package com.example.FactoryManager.entity;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Table(name = "file")
@Data
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class File {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "id", updatable = false, nullable = false)
    String id;

    @Column(name = "file_name")
    String fileName;

    @Column(name = "file_path")
    String filePath;

    @Column(name = "content_type")
    String contentType;

    @Column(name = "upload_date")
    LocalDateTime uploadDate;

    @Column(name = "uploaded_by")
    String uploadedBy;

    @Column(name = "has_deleted")
    Boolean hasDeleted;

    @Column(name = "updated_at")
    @UpdateTimestamp
    LocalDateTime updatedAt;

    @Column(name = "created_at")
    @CreationTimestamp
    LocalDateTime createdAt;
}
