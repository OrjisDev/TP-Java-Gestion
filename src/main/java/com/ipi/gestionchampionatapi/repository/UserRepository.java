package com.ipi.gestionchampionatapi.repository;

import com.ipi.gestionchampionatapi.entites.UserEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface UserRepository extends CrudRepository<UserEntity, Integer> {

    @Override
    List<UserEntity> findAll();

    Optional<UserEntity> findByEmail(String email);
}
