package com.example.FactoryManager.controller;

import com.example.FactoryManager.dto.response.ApiResponse;
import com.example.FactoryManager.dto.response.TeamResponse;
import com.example.FactoryManager.service.TeamService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AccessLevel;
import lombok.experimental.FieldDefaults;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/teams")
@Slf4j
@FieldDefaults(level = AccessLevel.PRIVATE)
@Tag(name = "Team Controller")
public class TeamController {

    @Autowired
    TeamService teamService;

    @GetMapping("/get")
    @Operation(
            summary = "Get list of teams",
            description = "Returns a list of teams",
            method = "GET"
    )
    public ApiResponse<List<TeamResponse>> getAllTeams() {
        log.info("Fetching all teams");
        List<TeamResponse> teamResponses = teamService.getAllteams();
        return ApiResponse.<List<TeamResponse>>builder()
                .code(200)
                .message("Success")
                .result(teamResponses)
                .build();
    }
}
