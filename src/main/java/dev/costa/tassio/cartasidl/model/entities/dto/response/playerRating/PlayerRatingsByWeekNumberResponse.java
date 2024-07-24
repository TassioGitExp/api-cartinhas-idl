package dev.costa.tassio.cartasidl.model.entities.dto.response.playerRating;

import com.fasterxml.jackson.core.JsonProcessingException;
import lombok.Getter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@Getter
public class PlayerRatingsByWeekNumberResponse {
    private int weekNumber;
    private final List<TeamPlusPlayersPoints> teams = new ArrayList<>();

    public PlayerRatingsByWeekNumberResponse responseOf(
                                                        final int weekNumber,
                                                        final HashMap<String, String> teams,
                                                        final String[] keyset,
                                                        final HashMap<String, List<Object[]>> hashMap) throws JsonProcessingException {
        this.weekNumber = weekNumber;

        int i = 0;

        while (i < keyset.length && hashMap.containsKey(keyset[i])){
            this.teams.add(new TeamPlusPlayersPoints().
                    responseOf(keyset[i], (String) teams.get(keyset[i]), hashMap.get((String) keyset[i])));
            i++;
        }

        return this;
    }
}
