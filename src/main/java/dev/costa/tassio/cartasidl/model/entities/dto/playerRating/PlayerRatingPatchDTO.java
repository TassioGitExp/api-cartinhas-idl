package dev.costa.tassio.cartasidl.model.entities.dto.playerRating;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class PlayerRatingPatchDTO {
    @JsonIgnore
    private int weekNumber;

    private String playerId;
    private int playerPoints;

}
