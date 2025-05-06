package com.example.FactoryManager.mapper;

import com.example.FactoryManager.dto.request.UIConfigRequest;
import com.example.FactoryManager.dto.response.UIConfigResponse;
import com.example.FactoryManager.entity.UIConfig;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring", uses = {UserMapper.class})
public interface UIMapper {

    UIConfig toUIConfig(UIConfigRequest uiConfigRequest);

    @Mapping(source = "user.id", target = "userId")
    UIConfigResponse toUIConfigResponse(UIConfig uiConfig);
}
