package com.hyparxis.evm.evmApplication.Services;


import com.hyparxis.evm.evmApplication.entity.Team;
import com.hyparxis.evm.evmApplication.Repositories.TeamRepository;
import com.hyparxis.evm.evmApplication.entity.TeamDetails;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class TeamServiceImpl implements TeamService{

    @Autowired
    private TeamRepository teamRepository;
    @Override
    public Team saveNewTeam(Team team) {
        return teamRepository.save(team);
    }

    @Override
    public List<Team> getAllTeams() {
        return teamRepository.findAll();
    }

    @Override
    public Optional<Team> getTeamById(Long id) {
        return teamRepository.findById(id);
    }

    @Override
    public void deleteTeamById(Long id) {
        teamRepository.deleteById(id);
    }

    @Override
    public Team updateTeamById(Long teamId, Team team) {
        Team teamToUpdate = teamRepository.findById(teamId).get();
        if (Objects.nonNull(teamToUpdate)) {
            if (Objects.nonNull(team.getTeamName()) && !"".equalsIgnoreCase(team.getTeamName())) {
                teamToUpdate.setTeamName(team.getTeamName());
            }
            if (Objects.nonNull(team.getTeamPurpose()) && !"".equalsIgnoreCase(team.getTeamPurpose())) {
                teamToUpdate.setTeamPurpose(team.getTeamPurpose());
            }
            if (Objects.nonNull(team.getTeamType()) && !"".equalsIgnoreCase(team.getTeamType())) {
                teamToUpdate.setTeamType(team.getTeamType());
            }
            if (Objects.nonNull(team.getTeamDetails())) {
                TeamDetails teamDetails = team.getTeamDetails();
                teamToUpdate.setTeamDetails(teamDetails);
            }
        }

        teamRepository.save(teamToUpdate);
        return teamToUpdate;
    }

    @Override
    public Optional<Team> getTeamByTeamName(String name) {
        return Optional.ofNullable(teamRepository.findByTeamName(name));
    }


}
