package com.hyparxis.evm.evmApplication.Services;

import com.hyparxis.evm.evmApplication.Repositories.TeamMemberRepository;
import com.hyparxis.evm.evmApplication.entity.TeamMember;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TeamMemberServiceImpl implements TeamMemberService{

    @Autowired
    private TeamMemberRepository teamMemberRepository;

    @Override
    public TeamMember saveNewTeammember(TeamMember teamMember) {
        return teamMemberRepository.save(teamMember);
    }

    @Override
    public List<TeamMember> getAllTeamMembers() {
        return teamMemberRepository.findAll();
    }
}
