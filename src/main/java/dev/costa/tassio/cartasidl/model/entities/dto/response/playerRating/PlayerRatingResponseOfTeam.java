package dev.costa.tassio.cartasidl.model.entities.dto.response.playerRating;

import dev.costa.tassio.cartasidl.model.entities.Player;
import dev.costa.tassio.cartasidl.model.entities.Team;
import lombok.Getter;
import lombok.ToString;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@Getter
@ToString
public class PlayerRatingResponseOfTeam {
    private String teamId;
    private String teamName;
    private List<PlayerPlusRating> playerRatings;

    public PlayerRatingResponseOfTeam responseOf(final Team team, final HashMap<String, List<Integer>> map){
        this.playerRatings = new ArrayList<>();
        int i = 0;

        for (Player p : team.getPlayerList()){
            this.playerRatings.add(new PlayerPlusRating().playerRatingFrom(team.getPlayerList().get(i),
                    map.get(p.getId())));
            i++;
        }

        this.teamId = team.getId();
        this.teamName = team.getName();

        return this;
    }

}
