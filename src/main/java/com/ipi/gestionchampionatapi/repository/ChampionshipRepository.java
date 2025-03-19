package com.ipi.gestionchampionatapi.repository;

import com.ipi.gestionchampionatapi.entites.ChampionshipEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ChampionshipRepository extends CrudRepository<ChampionshipEntity, Integer> {

    @Override
    List<ChampionshipEntity> findAll();

    ChampionshipEntity getChampionshipEntityById(int id);

    Optional<ChampionshipEntity> deleteChampionshipEntityById(int id);
}
