package com.example.FactoryManager.mapper;

import com.example.FactoryManager.dto.response.ItemResponse;
import com.example.FactoryManager.dto.response.UserResponse;
import com.example.FactoryManager.entity.Item;
import com.example.FactoryManager.entity.User;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface ItemMapper {

    @Mapping(source = "file.fileName", target = "fileName")
    @Mapping(expression = "java(item.getFTime())", target = "fTime")
    @Mapping(expression = "java(item.getMRate())", target = "mRate")
    ItemResponse toItemResponse(Item item);

}
