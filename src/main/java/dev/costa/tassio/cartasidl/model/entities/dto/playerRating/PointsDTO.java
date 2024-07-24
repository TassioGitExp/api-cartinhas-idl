package dev.costa.tassio.cartasidl.model.entities.dto.playerRating;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class PointsDTO {
    private int weekNumber;
    private int points;
}
