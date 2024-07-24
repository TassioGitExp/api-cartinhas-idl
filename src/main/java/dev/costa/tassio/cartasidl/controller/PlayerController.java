package dev.costa.tassio.cartasidl.controller;

import dev.costa.tassio.cartasidl.model.entities.dto.playerRating.TeamPlusPlayersDTO;
import dev.costa.tassio.cartasidl.model.entities.dto.response.PlayerResponse;
import dev.costa.tassio.cartasidl.model.entities.dto.response.playerRating.PlayerRatingResponseOfPlayer;
import dev.costa.tassio.cartasidl.model.entities.dto.response.playerRating.PlayerRatingResponseOfTeam;
import dev.costa.tassio.cartasidl.model.service.PlayerRatingService;
import dev.costa.tassio.cartasidl.model.service.PlayerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/player")
public class PlayerController {
    @Autowired
    private final PlayerService playerService;
    private final PlayerRatingService playerRatingService;

    public PlayerController(PlayerService playerService, PlayerRatingService playerRatingService){
        this.playerService = playerService;
        this.playerRatingService = playerRatingService;
    }

    @GetMapping("/get/{playerId}")
    public PlayerResponse getPlayerById(@PathVariable String playerId){
        return this.playerService.getPlayerById(playerId);
    }

    @GetMapping("/get-all")
    public List<PlayerResponse> getAllPlayers(){
        return this.playerService.getAllPlayers();
    }

    @GetMapping("/get-all-player-ratings-by-player-id/{playerId}")
    public PlayerRatingResponseOfPlayer getAllPlayerRatingsByPlayerId(@PathVariable String playerId){
        return this.playerRatingService.getAllPlayerRatingsFromPlayerId(playerId);
    }

    @GetMapping("/get-all-players-ratings-by-team-id/{teamId}")
    public PlayerRatingResponseOfTeam getAllPlayersRatingsByTeamId(@PathVariable String teamId){
        return this.playerRatingService.getPlayerRatingsOfTeam(teamId);
    }

    @GetMapping("/get-ratings-from-week/{weekNumber}")
    public TeamPlusPlayersDTO getRatingsByWeekNumberV2(
            @PathVariable Integer weekNumber){
        return this.playerRatingService.getRatingsByWeekNumber(weekNumber);
    }

    @GetMapping("/get-ratings-from-every-week")
    public List<TeamPlusPlayersDTO> getRatingsFromEveryWeekV2() {
        return this.playerRatingService.getRatingsFromEveryWeek();
    }
}
