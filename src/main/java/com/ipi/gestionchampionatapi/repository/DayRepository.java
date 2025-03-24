package com.ipi.gestionchampionatapi.repository;

import com.ipi.gestionchampionatapi.entites.DayEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DayRepository extends CrudRepository<DayEntity, Integer> {

    @Override
    List<DayEntity> findAll();

    List<DayEntity> findByChampionshipId(int id);

}
