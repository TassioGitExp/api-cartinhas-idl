package dev.costa.tassio.cartasidl.model.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "\"player_rating\"")
public class PlayerRating {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_player_rating", nullable = false)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "id_player")
    private Player player;

    @ManyToOne
    @JoinColumn(name = "id_week")
    private Week week;

    @Column(name = "points")
    private int points;
    @Column(name = "average_points")
    private int averagePoints;
}
