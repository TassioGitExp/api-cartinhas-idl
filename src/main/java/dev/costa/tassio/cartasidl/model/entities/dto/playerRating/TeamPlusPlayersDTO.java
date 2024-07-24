package dev.costa.tassio.cartasidl.model.entities.dto.playerRating;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.HashMap;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class TeamPlusPlayersDTO {
    private int weekNumber;
    private HashMap<String, List<PlayerDTO>> teamList;
}

