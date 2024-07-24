package dev.costa.tassio.cartasidl.model.entities.dto.request;

import com.fasterxml.jackson.annotation.JsonIgnore;
import dev.costa.tassio.cartasidl.model.entities.Team;
import dev.costa.tassio.cartasidl.model.entities.enums.Role;
import lombok.Setter;
import lombok.ToString;

@Setter
@ToString
public class PlayerRequest {
    private String name;
    private String nickname;
    private Role role;
    private String teamId;

    @JsonIgnore
    private Team team;
}
