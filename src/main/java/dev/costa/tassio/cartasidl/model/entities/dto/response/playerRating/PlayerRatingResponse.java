package dev.costa.tassio.cartasidl.model.entities.dto.response.playerRating;

import dev.costa.tassio.cartasidl.model.entities.Player;
import dev.costa.tassio.cartasidl.model.entities.PlayerRating;
import dev.costa.tassio.cartasidl.model.entities.Week;
import dev.costa.tassio.cartasidl.model.entities.dto.response.PlayerResponse;
import dev.costa.tassio.cartasidl.model.entities.dto.response.WeekResponse;
import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
public class PlayerRatingResponse {
    private PlayerResponse player;
    private WeekResponse week;
    private int points;
    private int avgPoints;

    public PlayerRatingResponse responseOf(final PlayerRating playerRating,
                                           final Player player,
                                           final Week week,
                                           final int avgPoints){
        this.player = new PlayerResponse().responseOf(player);
        this.week = new WeekResponse().responseOf(week);
        this.points = playerRating.getPoints();
        this.avgPoints = avgPoints;

        return this;
    }

}
