package com.example.FactoryManager.mapper;

import com.example.FactoryManager.dto.request.UserCreateRequest;
import com.example.FactoryManager.dto.response.UserResponse;
import com.example.FactoryManager.entity.User;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface UserMapper {
    User toUser(UserCreateRequest userCreateRequest);
    UserResponse toUserResponse(User user);

}
