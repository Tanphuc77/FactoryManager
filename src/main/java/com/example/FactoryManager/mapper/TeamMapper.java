package com.example.FactoryManager.mapper;

import com.example.FactoryManager.dto.response.TeamResponse;
import com.example.FactoryManager.entity.Team;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface TeamMapper {

    TeamResponse toTeamResponse(Team team);
}
