package dev.costa.tassio.cartasidl.model.entities.dto.request;

import com.fasterxml.jackson.annotation.JsonIgnore;
import dev.costa.tassio.cartasidl.model.entities.Player;
import dev.costa.tassio.cartasidl.model.entities.Week;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Setter
@ToString
public class PlayerRatingRequest {
    @Getter
    private String playerId;
    @Getter
    private Long weekId;

    private int points;

    @JsonIgnore
    private Player player;
    @JsonIgnore
    private Week week;
}
