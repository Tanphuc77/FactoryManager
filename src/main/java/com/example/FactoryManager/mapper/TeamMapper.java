package com.example.FactoryManager.mapper;

import com.example.FactoryManager.dto.response.TeamResponse;
import com.example.FactoryManager.entity.Team;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface TeamMapper {

    @Mapping(source = "id", target = "teamId")
    TeamResponse toTeamResponse(Team team);
}
