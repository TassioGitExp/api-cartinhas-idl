package dev.costa.tassio.cartasidl;

import dev.costa.tassio.cartasidl.model.entities.Player;
import dev.costa.tassio.cartasidl.model.entities.Team;
import dev.costa.tassio.cartasidl.model.entities.enums.MatchResult;
import dev.costa.tassio.cartasidl.model.repository.PlayerRepository;
import dev.costa.tassio.cartasidl.model.repository.TeamRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;

import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;


@ExtendWith(MockitoExtension.class)
public class MatchPlayerTest {

    @InjectMocks
    MatchPlayerService matchPlayerService;

    @Mock
    MatchPlayerRepository matchPlayerRepository;
    @Mock
    MatchRepository matchRepository;
    @Mock
    TeamRepository teamRepository;
    @Mock
    PlayerRepository playerRepository;

    Team teamBlue;
    Team teamRed;
    Match match;
    Player player;
    MatchPlayer matchPlayer;
    MatchPlayer matchPlayerFromReq;


    MatchPlayerRequest matchPlayerRequest;
    MatchPlayerResponse matchPlayerResponse;

    @BeforeEach
    public void setup(){
        // TODO: FIX THIS
//        player = new Player("1", "player_1", "nick_player_1", Role.ADC, null);
        teamBlue = new Team("id-team1", "team-blue", 1, 2, null);
        teamRed = new Team("id-team2", "team-red", 2, 1, null);
        match = new Match(1L, teamBlue, teamRed, MatchResult.BLUE, null);
        matchPlayer = new MatchPlayer(1L, player, teamBlue, match, 10, 2, 5);

        matchPlayerRequest = new MatchPlayerRequest();
        matchPlayerRequest.setPlayerId(matchPlayer.getPlayer().getId());
        matchPlayerRequest.setTeamId(matchPlayer.getTeam().getId());
        matchPlayerRequest.setMatchId(matchPlayer.getMatch().getId());
        matchPlayerRequest.setPlayerKills(matchPlayer.getPlayerKills());
        matchPlayerRequest.setPlayerDeaths(matchPlayer.getPlayerDeaths());
        matchPlayerRequest.setPlayerAssists(matchPlayer.getPlayerAssists());

        matchPlayerFromReq = matchPlayerRequest.toMatchPlayer(player, teamBlue, match);

        matchPlayerResponse = new MatchPlayerResponse().responseOf(matchPlayer);
    }

    @Test
    void testCreatePlayerMatch(){
        when(playerRepository.findById(player.getId())).thenReturn(Optional.of(player));
        when(teamRepository.findById(teamBlue.getId())).thenReturn(Optional.of(teamBlue));
        when(matchRepository.findById(match.getId())).thenReturn(Optional.of(match));

        System.out.println(matchPlayerRequest.toString());
        System.out.println(matchPlayerFromReq);

        var result = matchPlayerService.createNewPlayedMatch(matchPlayerRequest);

        assertNotNull(result);
    }

    @Test
    void getAllMatchesPlayedByPlayerId(){
        when(playerRepository.findById(player.getId())).thenReturn(Optional.of(player));

        var result = matchPlayerService.getAllMatchesPlayedByPlayerId(player.getId());
        System.out.println(result);

        assertNotNull(result);
    }

}
