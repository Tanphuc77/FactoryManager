package com.example.FactoryManager.dto.request;


import lombok.*;
import lombok.experimental.FieldDefaults;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
public class ItemImportRequest {

    String pieceNo;
    String itemNo;
    Integer quantity;
    String status;
    Integer readyQty;
    Integer deliveredQty;
    String storageUnit;
}
