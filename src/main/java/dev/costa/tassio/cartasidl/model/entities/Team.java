package dev.costa.tassio.cartasidl.model.entities;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
//@ToString
@Table(name = "\"team\"")
public class Team {
    @Id
    @Column(name = "id_team", nullable = false, unique = true)
    private String id;

    @Column(name = "name", nullable = false, unique = true)
    private String name;

    @Column(name = "wins", nullable = true, unique = false)
    private int wins;

    @Column(name = "loses", nullable = true, unique = false)
    private int loses;

    @OneToMany(mappedBy = "team", targetEntity = Player.class)
    private List<Player> playerList;

}
