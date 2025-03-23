package com.ipi.gestionchampionatapi.repository;

import com.ipi.gestionchampionatapi.entites.TeamEntity;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface TeamRepository extends CrudRepository<TeamEntity, Integer> {

    @Override
    List<TeamEntity> findAll();
}
