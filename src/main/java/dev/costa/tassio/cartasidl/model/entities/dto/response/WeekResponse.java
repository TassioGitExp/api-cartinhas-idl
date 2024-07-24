package dev.costa.tassio.cartasidl.model.entities.dto.response;

import com.fasterxml.jackson.annotation.JsonIgnore;
import dev.costa.tassio.cartasidl.model.entities.Week;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
public class WeekResponse {
    private Long id;
    private int weekNumber;
    private int round;

    @JsonIgnore
    private List<MatchResponse> matchList = new ArrayList<>();

    public WeekResponse responseOf(final Week week){
        this.id = week.getId();
        this.weekNumber = week.getWeekNumber();
        this.round = week.getRound();

        //TODO: Change this to get important info, not the object;
        for (Match match : week.getMatchList()){
            this.matchList.add(new MatchResponse().responseOf(match));
        }

        return this;
    }
}
