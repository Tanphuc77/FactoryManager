package com.example.FactoryManager.entity;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.JdbcTypeCode;
import org.hibernate.annotations.UpdateTimestamp;

import java.sql.Types;
import java.time.LocalDateTime;
import java.util.Set;
import java.util.UUID;

@Entity
@Table(name = "item")
@Data
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Item {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "id", updatable = false, nullable = false)
    UUID id;

    @Column(name = "piece_no")
    String pieceNo;

    @Column(name = "item_no")
    String itemNo;

    @Column(name = "quantity")
    Integer quantity;

    @Column(name = "status")
    String status;

    @Column(name = "picking_list")
    String pickingList;

    @Column(name = "description")
    String description;

    @Column(name = "qr_code")
    String qrCode;

    @Column(name = "item_note")
    String itemNote;

    @Column(name = "steel_material")
    String steelMaterial;

    @Column(name = "steel_gauge")
    Double steelGauge;

    @Column(name = "insulation")
    String insulation;

    @Column(name = "weight")
    Double weight;

    @Column(name = "area")
    Double area;

    @Column(name = "item_volume")
    Double itemVolume;

    @Column(name = "qc")
    String qc;

    @Column(name = "dims1")
    String dims1;

    @Column(name = "dims2")
    String dims2;

    @Column(name = "dims3")
    String dims3;

    @Column(name = "dims4")
    String dims4;

    @Column(name = "dims5")
    String dims5;

    @Column(name = "dims6")
    String dims6;

    @Column(name = "dims7")
    String dims7;

    @Column(name = "dims8")
    String dims8;

    @Column(name = "dims9")
    String dims9;

    @Column(name = "dims10")
    String dims10;

    @Column(name = "f_time")
    Double fTime;

    @Column(name = "m_rate")
    Double mRate;

    @Column(name = "connector1")
    String connector1;

    @Column(name = "connector2")
    String connector2;

    @Column(name = "connector3")
    String connector3;

    @Column(name = "connector4")
    String connector4;

    @Column(name = "material_weight")
    Double materialWeight;

    @Column(name = "insulation_material")
    String insulationMaterial;

    @Column(name = "insulation_area")
    Double insulationArea;

    @Column(name = "total_weight")
    Double totalWeight;

    @Column(name = "has_deleted")
    Boolean hasDeleted;

    @Column(name = "updated_at")
    @UpdateTimestamp
    LocalDateTime updatedAt;

    @Column(name = "created_at")
    @CreationTimestamp
    LocalDateTime createdAt;

    @Column(name = "product_code")
    String productCode;

    @Column(name = "duct_area")
    Double ductArea;

    @Column(name = "job_id")
    UUID jobId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "file_id")
    File file;

    @Column(name = "ready_qty")
    Integer readyQty;

    @Column(name = "delivered_qty")
    Integer deliveredQty;

    @Column(name = "qc_date")
    LocalDateTime qcDate;

    @Column(name = "qc_user_ids")
    String qcUserIds;
}