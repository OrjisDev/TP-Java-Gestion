package com.ipi.gestionchampionatapi.entites;

import jakarta.persistence.*;

@Entity
@Table(name = "day")
public class DayEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String number;

    @ManyToOne
    @JoinColumn(name = "idChampionship")
    private ChampionshipEntity championship;

    public DayEntity() {
        //do nothing
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public ChampionshipEntity getChampionship() {
        return championship;
    }

    public void setChampionship(ChampionshipEntity championship) {
        this.championship = championship;
    }
}
