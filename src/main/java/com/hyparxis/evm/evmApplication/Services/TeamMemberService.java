package com.hyparxis.evm.evmApplication.Services;

import com.hyparxis.evm.evmApplication.entity.TeamMember;
import org.springframework.stereotype.Service;

import java.util.List;

public interface TeamMemberService {

    TeamMember saveNewTeammember(TeamMember teamMember);

    List<TeamMember> getAllTeamMembers();
}
