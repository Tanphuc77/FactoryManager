package com.example.FactoryManager.dto.response;

import com.example.FactoryManager.entity.User;
import jakarta.persistence.Column;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UIConfigResponse {

    int id;

    String userId;

    String screenCode;

    String configJson;
}
