package dev.costa.tassio.cartasidl.model.entities.dto.response.playerRating;

import dev.costa.tassio.cartasidl.model.entities.Player;
import dev.costa.tassio.cartasidl.model.entities.Team;
import dev.costa.tassio.cartasidl.model.entities.dto.response.TeamResponse;
import lombok.Getter;
import lombok.ToString;

import java.util.List;

@Getter
@ToString
public class PlayerRatingResponseOfPlayer {
    private String playerId;
    private String playerNick;
    private TeamResponse team;
    private List<Integer> playerPoints;
    private int avgPoints;

    public PlayerRatingResponseOfPlayer responseOf(final Player player,
                                                   final Team team,
                                                   final List<Integer> playerPoints,
                                                   final int avgPoints){
        this.playerId = player.getId();
        this.playerNick = player.getNickname();
        this.team = new TeamResponse().responseOf(team);
        this.playerPoints = playerPoints;
        this.avgPoints = avgPoints;

        return this;
    }
}
