package com.hyparxis.evm.evmApplication.Controllers;

import com.hyparxis.evm.evmApplication.Services.TeamService;
import com.hyparxis.evm.evmApplication.entity.Team;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1/")
@RequiredArgsConstructor
public class TeamController {

    @Autowired
    private TeamService teamService;


    private final Logger LOGGER = LoggerFactory.getLogger(TeamController.class);

    @PostMapping("/teams")
    public Team saveNewTeam(@Valid @RequestBody Team team) {
        LOGGER.info("Inside saveTeam of TeamController");
        return teamService.saveNewTeam(team);
    }
    @GetMapping("/teams")
    public List<Team> getAllTeams() {
        return teamService.getAllTeams();
    }

    @GetMapping("/teams/id/{id}")
    public Optional<Team> getTeamById(@PathVariable Long id) {

        return teamService.getTeamById(id);
    }

    @GetMapping("/teams/name/{name}")
    public Optional<Team> getTeamByTeamName(@PathVariable String name) {
        return teamService.getTeamByTeamName(name);
    }
    @DeleteMapping("/teams/id/{id}")
    public void deleteTeamById(@PathVariable Long id) {
        teamService.deleteTeamById(id);
    }
    @PutMapping("/teams/id/{id}")
    public Team updateTeamById(@PathVariable("id") Long teamId, @RequestBody Team team) {
        return teamService.updateTeamById(teamId, team);

    }
}
