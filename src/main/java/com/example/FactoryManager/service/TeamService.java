package com.example.FactoryManager.service;

import com.example.FactoryManager.dto.response.TeamResponse;
import com.example.FactoryManager.entity.Team;
import com.example.FactoryManager.mapper.TeamMapper;
import com.example.FactoryManager.repository.TeamRepository;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
@Slf4j
public class TeamService {

    TeamRepository teamRepository;

    TeamMapper teamMapper;

    public List<TeamResponse> getAllteams(){
        var teams = teamRepository.findAll();

        return teams.stream().map(teamMapper::toTeamResponse).toList();
    }

}
