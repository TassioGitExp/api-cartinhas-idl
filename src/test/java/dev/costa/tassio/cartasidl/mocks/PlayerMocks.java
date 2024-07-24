package dev.costa.tassio.cartasidl.mocks;

import dev.costa.tassio.cartasidl.model.entities.Player;
import dev.costa.tassio.cartasidl.model.entities.Team;
import dev.costa.tassio.cartasidl.model.entities.dto.request.PlayerRequest;
import dev.costa.tassio.cartasidl.model.entities.enums.Role;

import java.util.ArrayList;
import java.util.List;

public class PlayerMocks {
    public Player mockPlayerEntity() {
        return mockPlayer(0);
    }

//TODO:
//    public Team mockTeam(){
//        return mockTeam(1);
//    }
//
//    public Team mockTeam(int i){
//        Team team = new Team();
//
//        team.setId("12345678");
//        team.setName("team");
//        team.setPlayerList(null);
//
//        return team;
//    }

    public PlayerRequest mockPlayerRequest() {
        return mockPlayerRequest(0);
    }

    public List<Player> mockPlayerList() {
        List<Player> PlayerList = new ArrayList<>();

        for (int i = 0; i < 4; i++) {
            PlayerList.add(mockPlayer(i));
        }
        return PlayerList;
    }

    public List<PlayerRequest> mockPlayerRequestList() {
        List<PlayerRequest> createPlayerRequestList = new ArrayList<>();

        for (int i = 0; i < 4; i++) {
            createPlayerRequestList.add(mockPlayerRequest(i));
        }
        return createPlayerRequestList;
    }

    public Player mockPlayer(int i) {
        Player player = new Player();

        player.setId("12345678-" + i);
        player.setName("player-" + i);
        player.setNickname("player_nickname-" + i);
        player.setRole(Role.ADC);
        player.setTeam(null);

        return player;
    }

    public PlayerRequest mockPlayerRequest(int i) {
        PlayerRequest playerRequest = new PlayerRequest();

//        playerRequest.setId("12345678-" + i);
        playerRequest.setName("player-" + i);
        playerRequest.setName("player" + i);
        playerRequest.setNickname("player_nickname-" + i);
        playerRequest.setRole(Role.ADC);
//        playerRequest.setTeamId(null);

        return playerRequest;
    }

    public PlayerRequest mockUpdatePlayerRequest(int i) {
        PlayerRequest playerRequest = new PlayerRequest();

//        playerRequest.setId("12345678-" + i);
        playerRequest.setName("player-" + i);
        playerRequest.setName("player" + i);
        playerRequest.setNickname("player_nickname-" + i);
        playerRequest.setRole(Role.ADC);
//        playerRequest.setTeamId(null);

        return playerRequest;
    }
}
