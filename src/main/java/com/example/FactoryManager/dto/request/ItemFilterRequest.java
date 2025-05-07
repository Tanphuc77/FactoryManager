package com.example.FactoryManager.dto.request;


import lombok.*;
import lombok.experimental.FieldDefaults;

import java.util.Map;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
public class ItemFilterRequest {
    private Map<String, String> filters;
}
