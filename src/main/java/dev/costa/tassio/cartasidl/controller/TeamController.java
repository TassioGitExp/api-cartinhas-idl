package dev.costa.tassio.cartasidl.controller;

import dev.costa.tassio.cartasidl.model.entities.dto.response.TeamResponse;
import dev.costa.tassio.cartasidl.model.service.TeamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/team")
public class TeamController {
    @Autowired
    private final TeamService teamService;

    public TeamController(TeamService teamService){
        this.teamService = teamService;
    }

    @GetMapping("/get/{teamId}")
    public TeamResponse getTeamById(@PathVariable String teamId){
        return this.teamService.getTeamById(teamId);
    }

    @GetMapping("/get-all")
    public List<TeamResponse> getAllTeams(){
        return this.teamService.findAllTeams();
    }
}
