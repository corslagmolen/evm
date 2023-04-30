package com.hyparxis.evm.evmApplication.Services;

import com.hyparxis.evm.evmApplication.entity.Team;

import java.util.List;
import java.util.Optional;

public interface TeamService {

    public Team saveNewTeam(Team team);

    public List<Team> getAllTeams();

    Optional<Team> getTeamById(Long id);

    void deleteTeamById(Long id);

    public Team updateTeamById(Long teamId, Team team);


    Optional<Team> getTeamByTeamName(String name);
}
