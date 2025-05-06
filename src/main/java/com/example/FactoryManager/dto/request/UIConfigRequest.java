package com.example.FactoryManager.dto.request;

import com.example.FactoryManager.entity.User;
import lombok.*;
import lombok.experimental.FieldDefaults;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class UIConfigRequest {
    String userId;

    String screenCode;

    String configJson;
}
