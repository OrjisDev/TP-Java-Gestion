package com.ipi.gestionchampionatapi.entites;

import jakarta.persistence.*;

@Entity
public class GameEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private int team1Point;

    private int team2Point;

    @ManyToOne
    @JoinColumn(name = "idTeam1")
    private TeamEntity team1;

    @ManyToOne
    @JoinColumn(name = "idTeam2")
    private TeamEntity team2;

    @ManyToOne
    @JoinColumn(name = "idDay")
    private DayEntity day;

}
