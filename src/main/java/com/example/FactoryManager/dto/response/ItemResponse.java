package com.example.FactoryManager.dto.response;

import com.example.FactoryManager.entity.File;
import jakarta.persistence.Column;
import jakarta.persistence.FetchType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.*;
import lombok.experimental.FieldDefaults;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDateTime;
import java.util.UUID;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
public class ItemResponse {

    String id;

    String pieceNo;

    String itemNo;

    Integer quantity;

    String status;

    String pickingList;

    String description;

    String qrCode;

    String itemNote;

    String steelMaterial;

    Double steelGauge;

    String insulation;

    Double weight;

    Double area;

    Double itemVolume;

    String qc;

    String dims1;

    String dims2;

    String dims3;

    String dims4;

    String dims5;

    String dims6;

    String dims7;

    String dims8;

    String dims9;

    String dims10;

    Double fTime;

    Double mRate;

    String connector1;

    String connector2;

    String connector3;

    String connector4;

    Double materialWeight;

    String insulationMaterial;

    Double insulationArea;

    Double totalWeight;

    Boolean hasDeleted;

    LocalDateTime updatedAt;

    LocalDateTime createdAt;

    String productCode;

    Double ductArea;

    UUID jobId;

    FileResponse file;

    Integer readyQty;

    Integer deliveredQty;

    LocalDateTime qcDate;

    String qcUserIds;
}
