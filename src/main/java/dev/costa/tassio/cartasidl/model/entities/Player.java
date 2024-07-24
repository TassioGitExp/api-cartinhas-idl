package dev.costa.tassio.cartasidl.model.entities;

import dev.costa.tassio.cartasidl.model.entities.enums.Role;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Table(name = "\"player\"")
public class Player {
    @Id
    @Column(name = "id_player", nullable = false, unique = true)
    private String id;

    @Column(name = "name", nullable = false)
    private String name;
    @Column(name = "nickname", nullable = false, unique = true)
    private String nickname;

    @Column(name = "role", nullable = false, unique = false)
    @Enumerated(EnumType.STRING)
    private Role role;

    @Column(name = "country", nullable = false, unique = false)
    private String country;

    @ManyToOne
    @JoinColumn(name = "id_team", nullable = true)
    private Team team;

}
