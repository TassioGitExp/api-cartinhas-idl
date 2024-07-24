package dev.costa.tassio.cartasidl.model.entities.dto.response.playerRating;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import dev.costa.tassio.cartasidl.model.entities.enums.Role;
import lombok.Getter;
import lombok.ToString;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

@Getter
@ToString
class PlayerPoints {
    private String playerId; // 0
    private String playerNick; // 1
    private String playerCountry; //  3
    private Role playerRole; //  2
    private int playerPoints; // 4
    private int playerAvgPoints; // 5

    @JsonIgnore
    ObjectMapper mapper = new ObjectMapper();

    public PlayerPoints pointsOf(Object[] playerList) throws JsonProcessingException {
        this.playerId = mapper.writeValueAsString(playerList[0])
                .replace("\\","").substring(1, playerList[0].toString().length()+1);
        this.playerNick = mapper.writeValueAsString(playerList[1])
                .replace("\\","").substring(1, playerList[1].toString().length()+1);
        this.playerPoints = mapper.convertValue(playerList[5], Integer.class);
        this.playerAvgPoints = mapper.convertValue(playerList[5], Integer.class);
        this.playerRole = mapper.convertValue(playerList[2], Role.class);
        this.playerCountry = mapper.writeValueAsString(playerList[3])
                .replace("\\","").substring(1, playerList[3].toString().length()+1);
        return this;
    }

}

@Getter
@ToString
public class TeamPlusPlayersPoints {
    private String teamId;
    private String teamName;
//    private String teamAveragePoints;
    private final List<PlayerPoints> players = new ArrayList<>();

    public TeamPlusPlayersPoints responseOf(
                                            String teamId,
                                            String teamName,
                                            List<Object[]> playerList) throws JsonProcessingException {
        this.teamId = teamId.replace("\\","").substring(1, teamId.length() -1);
        this.teamName = teamName.replace("\\","").substring(1, teamName.length() -1);

        for (int i = 0; i < playerList.size(); i++){
            players.add(new PlayerPoints().pointsOf(playerList.get(i)));
        }

        Collections.sort(players, Comparator.comparing(player -> player.getPlayerRole()));

        return this;
    }

}
