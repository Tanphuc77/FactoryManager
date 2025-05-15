package com.example.FactoryManager.mapper;

import com.example.FactoryManager.dto.request.SettingRequest;
import com.example.FactoryManager.dto.response.SettingResponse;
import com.example.FactoryManager.entity.Setting;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;

@Mapper(componentModel = "spring")
public interface SettingMapper {

    Setting toSetting(SettingRequest settingRequest);

    SettingResponse toSettingsResponse(Setting setting);

    void updateSetting(@MappingTarget Setting setting, SettingRequest settingRequest);
}
