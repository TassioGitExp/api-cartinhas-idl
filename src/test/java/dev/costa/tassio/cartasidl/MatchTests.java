package dev.costa.tassio.cartasidl;

import dev.costa.tassio.cartasidl.model.entities.Team;
import dev.costa.tassio.cartasidl.model.entities.Week;
import dev.costa.tassio.cartasidl.model.entities.enums.MatchResult;
import dev.costa.tassio.cartasidl.model.repository.TeamRepository;
import dev.costa.tassio.cartasidl.model.repository.WeekRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import static org.mockito.Mockito.*;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
public class MatchTests {

    @InjectMocks
    MatchService matchService;

    @Mock
    MatchRepository matchRepository;
    @Mock
    TeamRepository teamRepository;
    @Mock
    WeekRepository weekRepository;

    Team teamBlue;
    Team teamRed;
    Match match;
    Week week;

    MatchRequest matchRequest;
    MatchResponse matchResponse;

    @BeforeEach
    public void setup(){
        teamBlue = new Team("id-team1", "team-blue", 1, 2, null);
        teamRed = new Team("id-team2", "team-red", 2, 1, null);
        week = new Week(1L, 1, 1, null);
        match = new Match(null, teamBlue, teamRed, MatchResult.BLUE, null);

        matchRequest = new MatchRequest();
        matchRequest.setBlueSideId(teamBlue.getId());
        matchRequest.setRedSideId(teamRed.getId());
        matchRequest.setMatchResult(MatchResult.BLUE);
        matchRequest.setWeekId(null);

        matchResponse = new MatchResponse().responseOf(match);
    }

    @Test
    void createNewMatch(){
        when(teamRepository.findById(teamBlue.getId())).thenReturn(Optional.of(teamBlue));
        when(teamRepository.findById(teamRed.getId())).thenReturn(Optional.of(teamRed));

//        var req = matchRequest.toMatch(teamBlue, teamRed);
        var result = matchService.createMatch(matchRequest);

        System.out.println(result);

        assertNotNull(result);
//        verify(matchRepository).save(matchRequest.toMatch(teamBlue, teamRed));

    }
}
