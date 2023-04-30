package com.hyparxis.evm.evmApplication.teamMemberRepository;

import com.hyparxis.evm.evmApplication.Repositories.TeamMemberRepository;
import com.hyparxis.evm.evmApplication.entity.TeamMember;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
class TeamMemberRepositoryTest {
    @Autowired
    private TeamMemberRepository teamMemberRepository;


    @Test
    public void saveTeamMember() {
        TeamMember teamMember = TeamMember.builder()
                .firstName("Pluis")
                .lastName("Cat")
                .role("Sleep whole day")
                .email("pluis@gmail.com")
                .phone("77777777777")
                .build();
        teamMemberRepository.save(teamMember);
    }

    @Test
    public void findAllTeamMember() {
        List<TeamMember> teamMemberList =
                teamMemberRepository.findAll();
        System.out.println(teamMemberList);
    }

}