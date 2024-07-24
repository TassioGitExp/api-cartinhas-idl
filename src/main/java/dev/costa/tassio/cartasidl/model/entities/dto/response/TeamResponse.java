package dev.costa.tassio.cartasidl.model.entities.dto.response;

import dev.costa.tassio.cartasidl.model.entities.Player;
import dev.costa.tassio.cartasidl.model.entities.Team;
import lombok.Getter;
import lombok.ToString;

import java.util.ArrayList;
import java.util.List;

@Getter
@ToString
public class TeamResponse {
    private String id;
    private String name;
    private int wins;
    private int loses;
    private List<String> playerList = new ArrayList<>();

    public TeamResponse responseOf(final Team team){
        if(team == null){
            return null;
        }

        this.name = team.getName();
        this.id = team.getId();
        this.wins = team.getWins();
        this.loses = team.getLoses();

        if (team.getPlayerList().isEmpty() || team.getPlayerList() == null){
            this.playerList.clear();
        } else {
            for(Player player : team.getPlayerList()){
                this.playerList.add(player.getId());
            }
        }

        return this;
    }
}
