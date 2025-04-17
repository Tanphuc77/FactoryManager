package com.example.FactoryManager.mapper;

import com.example.FactoryManager.dto.request.UserCreateRequest;
import com.example.FactoryManager.dto.response.UserDetailResponse;
import com.example.FactoryManager.dto.response.UserResponse;
import com.example.FactoryManager.entity.User;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface UserMapper {
    User toUser(UserCreateRequest userCreateRequest);
    @Mapping(source = "role.name", target = "roleName")
    UserResponse toUserResponse(User user);
    @Mapping(source = "role.name", target = "roleName")
    UserDetailResponse toUserDetailResponse(User user);

}
