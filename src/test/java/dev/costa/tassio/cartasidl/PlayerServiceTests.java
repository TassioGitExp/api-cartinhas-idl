package dev.costa.tassio.cartasidl;

import dev.costa.tassio.cartasidl.model.entities.Player;
import dev.costa.tassio.cartasidl.model.entities.Team;
import dev.costa.tassio.cartasidl.model.entities.dto.request.PlayerRequest;
import dev.costa.tassio.cartasidl.model.entities.dto.response.PlayerResponse;
import dev.costa.tassio.cartasidl.model.entities.enums.Role;
import dev.costa.tassio.cartasidl.model.repository.PlayerRepository;
import dev.costa.tassio.cartasidl.model.repository.TeamRepository;
import dev.costa.tassio.cartasidl.model.service.PlayerService;
import org.junit.Ignore;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
@Ignore
public class PlayerServiceTests {

    @InjectMocks
    PlayerService playerService;

    @Mock
    PlayerRepository playerRepository;
    @Mock
    TeamRepository teamRepository;

    Player player1;
    Player player2;
    List<Player> playerlist;
    PlayerRequest playerRequest;
    PlayerRequest playerRequest2;
    PlayerResponse playerResponse;
    PlayerResponse playerResponse2;

    Team team;

//    @BeforeEach
    public void setup(){
        team = new Team("1", "team1", 1, 2,null);
        //TODO: FIX THIS
//        player1 = new Player("1", "player_1", "nick_player_1", Role.ADC, null);
//        player2 = new Player("2", "player_2", "nick_player_2", Role.MID, team);

        playerlist = new ArrayList<Player>();
        Collections.addAll(playerlist, player1, player2);

        playerRequest = new PlayerRequest();
        playerRequest.setName(player1.getName());
        playerRequest.setNickname(player1.getNickname());
        playerRequest.setRole(player1.getRole());
//        playerRequest.setTeamId("");

        playerResponse = new PlayerResponse().responseOf(player1);

        playerRequest2 = new PlayerRequest();
        playerRequest2.setName(player2.getName());
        playerRequest2.setNickname(player2.getNickname());
        playerRequest2.setRole(player2.getRole());
        playerRequest2.setTeam(team);

        playerResponse2 = new PlayerResponse().responseOf(player2);

        team.setPlayerList(playerlist);
    }

    @Test
    void createAPlayerFromPlayer(){
        System.out.println(playerRequest.toString());
//
        var result = playerService.createPlayer(playerRequest);
        System.out.println(result);

        assertEquals(playerResponse.getName(), result.getName());
        assertEquals(playerResponse.getNickname(), result.getNickname());
        assertEquals(playerResponse.getRole(), result.getRole());
//        assertEquals(playerResponse.getTeam().getId(), result.getTeam().getId());
        assertNull(result.getTeam());
//
//        verify(playerRepository).save(player1);
//        verifyNoMoreInteractions(playerRepository);
    }

    @Test
    void createAPlayerWithTeamFromPlayer(){
        team.getPlayerList().clear();
        System.out.println("players b4: "+team.getPlayerList());
        System.out.println("team: "+team);
        System.out.println("p2: "+player2);

        System.out.println(playerRequest2.toString());
//
        var result = playerService.createPlayer(playerRequest2);
        System.out.println("result: "+result);

        when(teamRepository.findById(team.getId())).thenReturn(Optional.of(team));
        var newPlayerList = teamRepository.findById(team.getId()).get().getPlayerList();

        assertEquals(playerResponse2.getName(), result.getName());
        assertEquals(playerResponse2.getNickname(), result.getNickname());
        assertEquals(playerResponse2.getRole(), result.getRole());
//        assertEquals(playerResponse.getTeam().getId(), result.getTeam().getId());
        assertEquals(team.getPlayerList(), newPlayerList);
        System.out.println("players: "+newPlayerList);
        assertNotNull(result.getTeam());
//
//        verify(playerRepository).save(player1);
//        verifyNoMoreInteractions(playerRepository);
    }

    @Test
    void updateAPlayerFromPlayer(){
        when(playerRepository.findById(player1.getId())).thenReturn(Optional.of(player1));
        when(playerRepository.save(player1)).thenReturn(Optional.of(player1).get());

        System.out.println(playerRequest.toString());

//        var playerResult = playerService.createPlayer(playerRequest);
//        System.out.println(playerResult);
//
        playerRequest.setName("UPDATED");
        var result = playerService.updatePlayerById(player1.getId(), playerRequest);

        assertEquals("UPDATED", result.getName());
        assertEquals(playerResponse.getNickname(), result.getNickname());
        assertEquals(playerResponse.getRole(), result.getRole());
//        assertEquals(playerResponse.getTeam().getId(), result.getTeam().getId());
        assertNull(result.getTeam());
//
//        verify(playerRepository).save(player1);
//        verifyNoMoreInteractions(playerRepository);
    }

    @Test
    void findPlayerById(){
        when(playerRepository.findById(player1.getId())).thenReturn(Optional.of(player1));

        var result = playerService.getPlayerById(player1.getId());

        assertEquals(Optional.of(player1).get().getId(), result.getId());
//        assertEquals("fail", result.getId());
        assertEquals(Optional.of(player1).get().getName(), result.getName());
        assertEquals(Optional.of(player1).get().getNickname(), result.getNickname());
        assertEquals(Optional.of(player1).get().getRole(), result.getRole());
        assertEquals(Optional.of(player1).get().getTeam(), result.getTeam());

        verify(playerRepository).findById(player1.getId());
        verifyNoMoreInteractions(playerRepository);
    }

    @Test
    void getAListOfAllPlayers(){
        when(playerRepository.findAll()).thenReturn(playerlist);

        var result = playerService.getAllPlayers();

        int i = 0;
        for(Player player : playerlist) {
            assertEquals(player.getName(), result.get(i).getName());
            assertEquals(player.getNickname(), result.get(i).getNickname());
            assertEquals(player.getRole(), result.get(i).getRole());
//            assertEquals(playerResponse2.getTeam(), result.get(i).getTeam());
            i++;
        }

        verify(playerRepository).findAll();
        verifyNoMoreInteractions(playerRepository);
    }

}
