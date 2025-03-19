package com.ipi.gestionchampionatapi.controller;

import com.ipi.gestionchampionatapi.entites.ChampionshipEntity;
import com.ipi.gestionchampionatapi.repository.ChampionshipRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/championship")
public class ChampionshipController {

    @Autowired
    public ChampionshipRepository repository;

    @GetMapping("/getall")
    public List<ChampionshipEntity> getAllChampionships() {
        return repository.findAll();
    }

    @GetMapping("/get/{id}")
    public ChampionshipEntity getChampionshipById(@PathVariable(name = "id",required = true) int id) {
        Optional<ChampionshipEntity> championshipEntity = repository.findById(id);
        if (championshipEntity.isPresent()) {
            return championshipEntity.get();
        }
        else throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Championnat introuvable");
    }

    @PostMapping("/create")
    public ChampionshipEntity createChampionship(@RequestBody ChampionshipEntity entity) {
        if(entity == null) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Mauvaise requête");
        }
        return repository.save(entity);
    }

    @PostMapping("/update/{id}")
    public ChampionshipEntity updateChampionship(@PathVariable(name = "id", required = true) int id,
                                                 @RequestBody ChampionshipEntity entity) {
        if(entity == null) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Mauvaise requete");
        }
        Optional<ChampionshipEntity> actualChampionship = repository.findById(id);
        if (actualChampionship.isEmpty()) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Championnat introuvable");
        }
        else{
            entity.setId(actualChampionship.get().getId());
            return repository.save(entity);
        }
    }

    @PostMapping("/delete/{id}")
    public ChampionshipEntity deleteChampionship(@PathVariable(name = "id", required = true) int id) {
        Optional<ChampionshipEntity> championshipEntity = repository.findById(id);
        if (championshipEntity.isPresent()) {
            repository.delete(championshipEntity.get());
            return championshipEntity.get();
        }
        else throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Championnat introuvable");
    }

}
