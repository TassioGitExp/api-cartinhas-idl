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
@Table(name = "\"week\"")
public class Week {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_week", nullable = false)
    private Long id;
    @Column(name = "week_number", nullable = false, unique = false)
    private int weekNumber;
    @Column(name = "round", nullable = false, unique = false)
    private int round;
}
