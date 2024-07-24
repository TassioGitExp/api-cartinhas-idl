package dev.costa.tassio.cartasidl.model.service;

import dev.costa.tassio.cartasidl.model.entities.Player;
import dev.costa.tassio.cartasidl.model.entities.dto.playerRating.PlayerDTO;
import dev.costa.tassio.cartasidl.model.entities.dto.playerRating.PlayerRatingDTO;
import dev.costa.tassio.cartasidl.model.entities.dto.playerRating.TeamPlusPlayersDTO;
import dev.costa.tassio.cartasidl.model.entities.dto.response.playerRating.PlayerRatingResponseOfPlayer;
import dev.costa.tassio.cartasidl.model.entities.dto.response.playerRating.PlayerRatingResponseOfTeam;
import dev.costa.tassio.cartasidl.model.entities.enums.Role;
import dev.costa.tassio.cartasidl.model.repository.PlayerRatingRepository;
import dev.costa.tassio.cartasidl.model.repository.PlayerRepository;
import dev.costa.tassio.cartasidl.model.repository.TeamRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class PlayerRatingService {
    @Autowired
    private final PlayerRatingRepository playerRatingRepository;
    private final TeamRepository teamRepository;
    private final PlayerRepository playerRepository;

    public PlayerRatingService(PlayerRatingRepository playerRatingRepository,
                               TeamRepository teamRepository,
                               PlayerRepository playerRepository){
        this.playerRatingRepository = playerRatingRepository;
        this.teamRepository = teamRepository;
        this.playerRepository = playerRepository;
    }

    public int getPlayerAveragePoints(String playerId){
        if(playerRatingRepository.getAveragePoints(playerId) == null){
            return 0;
        } else
            return playerRatingRepository.getAveragePoints(playerId);
    }

    public PlayerRatingResponseOfPlayer getAllPlayerRatingsFromPlayerId(String playerId){
        var player = playerRepository.findById(playerId)
                .orElseThrow(() -> new RuntimeException("Player not found!"));
        var team = player.getTeam();
        var playerPoints = playerRatingRepository.getPlayerPoints(playerId);
        var avgPoints = getPlayerAveragePoints(playerId);

        return new PlayerRatingResponseOfPlayer().responseOf(player, team, playerPoints, avgPoints);
    }

    public PlayerRatingResponseOfTeam getPlayerRatingsOfTeam(String teamId){
        var team = teamRepository.findById(teamId)
                .orElseThrow(() -> new RuntimeException("Team not found!"));

        HashMap<String, List<Integer>> playerPointsMap = new HashMap<>();

        for (Player p : team.getPlayerList()){
            playerPointsMap.put(p.getId(), playerRatingRepository.getPlayerPoints(p.getId()));
        }

        return new PlayerRatingResponseOfTeam().responseOf(team, playerPointsMap);
    }

    public TeamPlusPlayersDTO buildRatingsDTO(
            List<PlayerRatingDTO> list, int weekNumber){

        HashMap<String, String> teamHashMap = new HashMap<>();
        List<PlayerDTO> playerList = new ArrayList<>();


        HashMap<String, List<PlayerDTO>> finalMap = new HashMap<>();
        for (PlayerRatingDTO playerRating: list){
            if (!teamHashMap.containsKey(playerRating.getId_team())){
                teamHashMap
                        .put(playerRating.getId_team(),
                                playerRating.getTeam_name());
            }
        }

        Set<String> keys = teamHashMap.keySet();
        String[] keysArray = keys.toArray(new String[0]);

        int tamanho = keysArray.length;
        Arrays.sort(keysArray);

        int x = 0;
        int z = 0;
        while (x < tamanho){
            if (z < list.size() && Objects.equals(list.get(z).getId_team(), keysArray[x])){

                var maxPoints = playerRatingRepository
                        .getPlayerMaxPoints(list.get(z).getId_player());
                var minPoints = playerRatingRepository
                        .getPlayerMinPoints(list.get(z).getId_player());

                playerList.add(new PlayerDTO(list.get(z).getId_player(),
                        list.get(z).getPlayer_nick(),
                        list.get(z).getCountry(),
                        Role.valueOf(String.valueOf(list.get(z).getPlayer_role())),
                        list.get(z).getPoints(),
                        list.get(z).getAveragePoints(),
                        maxPoints,
                        minPoints));
                z++;
            } else {
                List<PlayerDTO> playerListCopy = new ArrayList<>(playerList);
                finalMap.put(teamHashMap.get(keysArray[x]), playerListCopy);

                playerList.clear();
                x++;
            }
        }

        return new TeamPlusPlayersDTO(weekNumber, finalMap);
    }

    public TeamPlusPlayersDTO getRatingsByWeekNumber(int weekNumber){
        var ratings = playerRatingRepository.findPlayerRatingsByWeek(weekNumber);
        System.out.println(ratings.get(0).getPlayer_nick());
        return buildRatingsDTO(ratings, weekNumber);
    }

    public List<TeamPlusPlayersDTO> getRatingsFromEveryWeek(){
        var responseList = new ArrayList<TeamPlusPlayersDTO>();

        int weekNumber = 1;
        while (playerRatingRepository.existsByWeekWeekNumber(weekNumber)){
            var weekRatings = playerRatingRepository.findPlayerRatingsByWeek(weekNumber);

            responseList.add(buildRatingsDTO(weekRatings, weekNumber));

            weekNumber++;
        }

        return responseList;
    }
}
