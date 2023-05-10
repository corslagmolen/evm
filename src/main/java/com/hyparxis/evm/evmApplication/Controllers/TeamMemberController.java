package com.hyparxis.evm.evmApplication.Controllers;

import com.hyparxis.evm.evmApplication.Services.TeamMemberService;
import com.hyparxis.evm.evmApplication.entity.TeamMember;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/")
public class TeamMemberController {

    @Autowired
    private TeamMemberService teamMemberService;

    @PostMapping("/teammembers")
    public TeamMember saveNewTeammember(@RequestBody TeamMember teamMember){
        return teamMemberService.saveNewTeammember(teamMember);


    }
    @GetMapping("/teammembers")
    public List<TeamMember> getAllTeamMembers(){
        return teamMemberService.getAllTeamMembers();


    }
}
