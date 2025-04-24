package com.example.FactoryManager.mapper;

import com.example.FactoryManager.dto.request.UserCreateRequest;
import com.example.FactoryManager.dto.request.UserUpdateRequest;
import com.example.FactoryManager.dto.response.UserDetailResponse;
import com.example.FactoryManager.dto.response.UserResponse;
import com.example.FactoryManager.entity.User;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

@Mapper(componentModel = "spring")
public interface UserMapper {
    User toUser(UserCreateRequest userCreateRequest);
    @Mapping(source = "id", target = "userId")
    @Mapping(source = "role.name", target = "roleName")
    UserResponse toUserResponse(User user);

    @Mapping(source = "id", target = "userId")
    @Mapping(source = "role.name", target = "roleName")
    UserDetailResponse toUserDetailResponse(User user);

    void updateUser(@MappingTarget User user, UserUpdateRequest userRequest);

}
