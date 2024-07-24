package dev.costa.tassio.cartasidl.model.service;

import dev.costa.tassio.cartasidl.model.entities.Team;
import dev.costa.tassio.cartasidl.model.entities.dto.response.TeamResponse;
import dev.costa.tassio.cartasidl.model.repository.TeamRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class TeamService {

    @Autowired
    private final TeamRepository teamRepository;

    public TeamService(TeamRepository teamRepository){
        this.teamRepository = teamRepository;
    }

    public List<TeamResponse> findAllTeams(){
        var teamList = teamRepository.findAll();
        List<TeamResponse> teamResponseList = new ArrayList<>();

        for (Team team : teamList){
            var teamResponse = new TeamResponse().responseOf(team);
            System.out.println(team.getPlayerList());

            teamResponseList.add(teamResponse);
        }

        return teamResponseList;
    }

    public TeamResponse getTeamById(String id){
        var team = teamRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Team not found!"));

        return new TeamResponse().responseOf(team);
    }
}
