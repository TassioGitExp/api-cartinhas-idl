package dev.costa.tassio.cartasidl.model.repository;

import dev.costa.tassio.cartasidl.model.entities.PlayerRating;
import dev.costa.tassio.cartasidl.model.entities.dto.playerRating.PlayerRatingDTO;
import dev.costa.tassio.cartasidl.model.entities.dto.playerRating.PointsDTO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PlayerRatingRepository extends JpaRepository<PlayerRating, Long> {
    @Query("SELECT AVG(pr.points) FROM PlayerRating pr WHERE pr.player.id = :playerId")
    Integer getAveragePoints(@Param("playerId") String playerId);

    @Query("SELECT pr.points FROM PlayerRating pr WHERE pr.player.id = :playerId")
    List<Integer> getPlayerPoints(@Param("playerId") String playerId);

    @Query("SELECT NEW dev.costa.tassio.cartasidl.model.entities.dto.playerRating.PlayerRatingDTO(" +
            "t.id AS id_team, t.name AS team_name, " +
            "p.id AS id_player, p.nickname AS player_nick, p.role AS player_role , " +
            "p.country AS country, pr.points AS points, pr.averagePoints AS averagePoints, " +
            "pr.week.weekNumber AS week_number) " +
            "FROM Team t " +
            "JOIN Player p ON t.id = p.team.id " +
            "JOIN PlayerRating pr ON p.id = pr.player.id " +
            "WHERE pr.week.weekNumber = :weekNumber " +
            "ORDER BY t.id, p.nickname")
    List<PlayerRatingDTO> findPlayerRatingsByWeek(@Param("weekNumber") Integer weekNumber);

    @Query("SELECT NEW dev.costa.tassio.cartasidl.model.entities.dto.playerRating.PointsDTO(" +
            "pr.week.weekNumber, MAX(pr.points)) " +
            "FROM Team t " +
            "JOIN Player p ON t.id = p.team.id " +
            "JOIN PlayerRating pr ON p.id = pr.player.id " +
            "WHERE pr.player.id = :playerId " +
            "GROUP BY pr.week.weekNumber " +
            "ORDER BY MAX(pr.points) DESC " +
            "LIMIT 1")
    PointsDTO getPlayerMaxPoints(@Param("playerId") String playerId);

    @Query("SELECT NEW dev.costa.tassio.cartasidl.model.entities.dto.playerRating.PointsDTO(" +
            "pr.week.weekNumber, MAX(pr.points)) " +
            "FROM Team t " +
            "JOIN Player p ON t.id = p.team.id " +
            "JOIN PlayerRating pr ON p.id = pr.player.id " +
            "WHERE pr.player.id = :playerId " +
            "GROUP BY pr.week.weekNumber " +
            "ORDER BY MAX(pr.points) ASC " +
            "LIMIT 1")
    PointsDTO getPlayerMinPoints(@Param("playerId") String playerId);


    boolean existsByWeekWeekNumber(int weekNumber);
}
