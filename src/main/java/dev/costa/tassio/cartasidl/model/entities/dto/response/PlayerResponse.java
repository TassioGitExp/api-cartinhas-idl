package dev.costa.tassio.cartasidl.model.entities.dto.response;

import dev.costa.tassio.cartasidl.model.entities.Player;
import dev.costa.tassio.cartasidl.model.entities.enums.Role;
import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
public class PlayerResponse {
    private String id;
    private String name;
    private String nickname;
    private String country;
    private Role role;
    
    private TeamResponse team;

    public void setTeam(TeamResponse team) {
        this.team = team;
    }

    public PlayerResponse responseOf(final Player player){
        this.id = player.getId();
        this.name = player.getName();
        this.nickname = player.getNickname();
        this.country = player.getCountry();
        this.role = player.getRole();
        this.team = new TeamResponse().responseOf(player.getTeam());

        return  this;
    }
}
