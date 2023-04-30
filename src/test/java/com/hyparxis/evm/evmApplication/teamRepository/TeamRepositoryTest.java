package com.hyparxis.evm.evmApplication.teamRepository;

import com.hyparxis.evm.evmApplication.Repositories.TeamRepository;
import com.hyparxis.evm.evmApplication.entity.Team;
import com.hyparxis.evm.evmApplication.entity.TeamDetails;
import com.hyparxis.evm.evmApplication.entity.TeamMember;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@SpringBootTest
// @DataJpaTest
class TeamRepositoryTest {
    @Autowired
    private TeamRepository teamRepository;

    TeamDetails teamDetails = TeamDetails.builder()
            .teamDomain("Finance")
            .teamOrganization("Hyparxis")
            .build();

   @Test
    public void saveTeam() {
        Team team = Team.builder()
                .teamName("Pega5-Team")
                .teamPurpose("Order & Delivery")
                .teamType("Feature")
                .teamDetails(teamDetails)
                .build();
        teamRepository.save(team);
    }

    @Test
    public void printAllTeams() {
       List<Team> teamList =
               teamRepository.findAll();
       System.out.println("Team list: " + teamList);
    }

    @Test
    public void printAllTeamsByOrganization() {
       List<Team> teamList =
               teamRepository.findByTeamDetailsTeamOrganization("Hyparxis");
       System.out.println("Teams in Organization LeasePlan: "+ teamList);
    }
    @Test
    public void findTeamByTeamName() {
        Team team =
                teamRepository.findByTeamName("Pega888");
        System.out.println("Teams in Organization LeasePlan: "+ team);
    }
    @Test
    public void findTeamByTeamNameContains() {
        List<Team> teams =
                teamRepository.findByTeamNameContaining("Pega");
        System.out.println("Teams in Organization LeasePlan: "+ teams);
    }
    @Test
    public void getTeamName() {
        String name =
                teamRepository.getTeamName("BLS-Teams");
        System.out.println("Team name is: "+ name);
    }

    @Test
    public void getAllTeamsNative() {
        List<Team> teams =
                teamRepository.getAllTeamsNative();
        System.out.println("Teams : "+ teams);
    }
    @Test
    public void getTeamByNameNat() {
        Team team  =
                teamRepository.getTeamByNameNative("BLS-Teams");
        System.out.println("Team is: "+ team);
    }

    @Test
    public void updateTeamNameById() {
        int ok  =
                teamRepository.updateTeamNameByTeamId((long) 22.00, "JopieTeam");
        System.out.println("Team is: "+ ok);
    }



    @Test
    public void updateTeamNameByIdJpa() {
        Optional<Team> optionalTeam = teamRepository.findById(Long.valueOf(2));
        if (optionalTeam.isPresent()) {
            Team team = optionalTeam.get();
            team.setTeamName("catsTeam-001");

            // Save the entity
            teamRepository.save(team);
        }
    }

    @Test
    public void updateTeamDetailsByIdJpa() {
        Optional<Team> optionalTeam = teamRepository.findById(Long.valueOf(1));
        if (optionalTeam.isPresent()) {
            Team team = optionalTeam.get();
            TeamDetails teamDetails = TeamDetails.builder()
                    .teamDomain("Domain1")
                    .teamOrganization("Hyparxis-22")
                    .build();
            team.setTeamDetails(teamDetails);

            // Save the entity
            teamRepository.save(team);
        }
    }
    @Test
    public void addTeamWithTwoTeamMembers() {

        List<TeamMember> teamMembersList = new ArrayList<TeamMember>();

        TeamMember teamMember1 = TeamMember.builder()
                .firstName("Pluis")
                .lastName("Cat")
                .role("Sleep whole day")
                .email("pluis@gmail.com")
                .phone("77777777777")
                .build();
        TeamMember teamMember2 = TeamMember.builder()
                .firstName("Bikkie")
                .lastName("Cat")
                .role("Sleep whole day")
                .email("Bikkie@gmail.com")
                .phone("9999999")
                .build();
        teamMembersList.add(teamMember1);
        teamMembersList.add(teamMember2);
        Team team = Team.builder()
                .teamName("cats-Team")
                .teamPurpose("Sleep")
                .teamType("DoNothing")
                .teamDetails(teamDetails)
                .teamMembers(teamMembersList)
                .build();


            teamRepository.save(team);
        }
    }

