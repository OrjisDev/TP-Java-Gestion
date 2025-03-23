package com.ipi.gestionchampionatapi.entites;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;
import java.util.List;

@Entity
public class TeamEntity {

    @Setter
    @Getter
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Setter
    @Getter
    private String name;

    @Setter
    @Getter
    private Date creationDate;

    @Setter
    @Getter
    @ManyToMany(
            fetch = FetchType.LAZY,
            cascade = {
                    CascadeType.PERSIST,
                    CascadeType.MERGE
            }
    )
    private List<ChampionshipEntity> championship;

    public TeamEntity() {
        // do nothing
    }

}
