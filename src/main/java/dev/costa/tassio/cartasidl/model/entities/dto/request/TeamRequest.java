package dev.costa.tassio.cartasidl.model.entities.dto.request;

import dev.costa.tassio.cartasidl.model.entities.Player;
import lombok.Setter;
import lombok.ToString;

import java.util.List;

@Setter
@ToString
public class TeamRequest {
    private String name;
    private int wins;
    private int loses;
    private List<Player> playerList;
}
