package dev.costa.tassio.cartasidl.model.entities.dto.playerRating;

import dev.costa.tassio.cartasidl.model.entities.enums.Role;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class PlayerDTO {
    private String playerId; // 0
    private String playerNick; // 1
    private String playerCountry; //  3
    private Role playerRole; //  2
    private int playerPoints; // 4
    private int playerAvgPoints; // 5
    private PointsDTO playerMaxPoints; // 6
    private PointsDTO playerMinPoints; // 7
}