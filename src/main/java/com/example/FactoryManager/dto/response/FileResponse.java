package com.example.FactoryManager.dto.response;

import jakarta.persistence.Column;
import lombok.*;
import lombok.experimental.FieldDefaults;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
public class FileResponse {

    String id;

    String fileName;

    String filePath;

    String contentType;

    LocalDateTime uploadDate;

    String uploadedBy;

    Boolean hasDeleted;

    LocalDateTime updatedAt;

    LocalDateTime createdAt;
}
