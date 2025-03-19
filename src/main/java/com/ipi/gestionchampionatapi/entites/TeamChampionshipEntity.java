package com.ipi.gestionchampionatapi.entites;

import jakarta.persistence.*;

import java.util.List;

@Entity
public class TeamChampionshipEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @ManyToMany(
            fetch = FetchType.LAZY,
            cascade = {
                    CascadeType.PERSIST,
                    CascadeType.MERGE
            }
    )
    private List<ChampionshipEntity> championship;

    @ManyToMany(
            fetch = FetchType.LAZY,
            cascade = {
                    CascadeType.PERSIST,
                    CascadeType.MERGE
            }
    )
    private List<TeamEntity> team;

    public TeamChampionshipEntity() {
        //do nothing
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public List<ChampionshipEntity> getChampionship() {
        return championship;
    }

    public void setChampionship(List<ChampionshipEntity> championship) {
        this.championship = championship;
    }

    public List<TeamEntity> getTeam() {
        return team;
    }

    public void setTeam(List<TeamEntity> team) {
        this.team = team;
    }
}
