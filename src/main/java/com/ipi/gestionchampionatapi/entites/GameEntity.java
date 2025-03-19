package com.ipi.gestionchampionatapi.entites;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Entity
public class GameEntity {

    @Getter
    @Setter
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Getter
    @Setter
    private int team1Point;

    @Getter
    @Setter
    private int team2Point;

    @Getter
    @Setter
    @ManyToOne
    @JoinColumn(name = "idTeam1")
    private TeamEntity team1;

    @Getter
    @Setter
    @ManyToOne
    @JoinColumn(name = "idTeam2")
    private TeamEntity team2;
    
    @Getter
    @Setter
    @ManyToOne
    @JoinColumn(name = "idDay")
    private DayEntity day;
}
