package dev.costa.tassio.cartasidl.model.entities.dto.request;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Setter
@ToString
public class WeekRequest {
    @Getter
    private int weekNumber;

    private int round;
}
