package com.example.FactoryManager.dto.request;

import com.example.FactoryManager.enums.UserStatus;
import lombok.*;
import lombok.experimental.FieldDefaults;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
public class UserSearchRequest {
    String keyword;
    String role;
    UserStatus status;
}
