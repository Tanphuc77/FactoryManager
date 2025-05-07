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
    ItemResponse toItemResponse(Item item);

}
