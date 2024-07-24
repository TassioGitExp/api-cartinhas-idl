package dev.costa.tassio.cartasidl.model.entities.dto.response.playerRating;

import dev.costa.tassio.cartasidl.model.entities.Player;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
class PlayerPlusRating {
    private String playerId;
    private String playerNick;
    private List<Integer> points;

    public PlayerPlusRating playerRatingFrom(final Player player, List<Integer> pointsList) {
        this.playerId = player.getId();
        this.playerNick = player.getNickname();
        this.points = pointsList;

        return this;
    }
}
