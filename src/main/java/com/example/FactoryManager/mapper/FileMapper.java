package com.example.FactoryManager.mapper;

import com.example.FactoryManager.dto.response.FileResponse;
import com.example.FactoryManager.entity.File;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface FileMapper {

    FileResponse toFileResponse(File file);
}
