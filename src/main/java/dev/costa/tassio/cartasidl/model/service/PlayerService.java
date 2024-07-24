package dev.costa.tassio.cartasidl.model.service;

import dev.costa.tassio.cartasidl.model.entities.Player;
import dev.costa.tassio.cartasidl.model.entities.dto.response.PlayerResponse;
import dev.costa.tassio.cartasidl.model.entities.dto.response.TeamResponse;
import dev.costa.tassio.cartasidl.model.repository.PlayerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class PlayerService {

    @Autowired
    private final PlayerRepository playerRepository;

    public PlayerService (PlayerRepository playerRepository){
        this.playerRepository = playerRepository;
    }

    public List<PlayerResponse> getAllPlayers (){
        List<Player> playerList = playerRepository.findAll();

        List<PlayerResponse> playerResponseList = new ArrayList<>();

        for (Player player : playerList) {
            var playerResponse = new PlayerResponse().responseOf(player);

            if(player.getTeam() != null){
                playerResponse.setTeam(new TeamResponse().responseOf(player.getTeam()));
            }

            playerResponseList.add(playerResponse);
        }

        return playerResponseList;
    }

    public PlayerResponse getPlayerById(String id){
        var player = playerRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Player not found!"));

        var playerResponse = new PlayerResponse().responseOf(player);

        if(player.getTeam() != null){
            playerResponse.setTeam(new TeamResponse().responseOf(player.getTeam()));
            System.out.println("service: "+playerResponse);

        }

        return playerResponse;
    }
}
