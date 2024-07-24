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
public class PlayerRatingDTO {
    private String id_team;
    private String team_name;
    private String id_player;
    private String player_nick;
    private Role player_role;
    private String country;
    private Integer points;
    private Integer averagePoints;
    private Integer week_number;
}
