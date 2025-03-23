package com.ipi.gestionchampionatapi.controller;

import com.ipi.gestionchampionatapi.entites.TeamEntity;
import com.ipi.gestionchampionatapi.repository.TeamRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/team")
public class TeamController {

    @Autowired
    public TeamRepository repository;

    @GetMapping("/getall")
    public List<TeamEntity> getAllTeams(){return repository.findAll();}

    @GetMapping("/get/{id}")
    public TeamEntity getTeamById(@PathVariable int id){
        Optional<TeamEntity> team = repository.findById(id);
        if(team.isPresent()){
            return team.get();
        }
        else throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Team not found");
    }

    @PostMapping("/create")
    public TeamEntity createTeam(@Valid @RequestBody TeamEntity team){
        if (team == null) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Team cannot be null");
        }
        return repository.save(team);
    }

    @PostMapping("/update/{id}")
    public TeamEntity updateTeam(@PathVariable int id, @Valid @RequestBody TeamEntity team){
        if (team == null) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Team cannot be null");
        }
        Optional<TeamEntity> teamEntity = repository.findById(id);
        if (teamEntity.isEmpty()) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Team not found");
        }
        else{
            team.setId(teamEntity.get().getId());
            return repository.save(team);
        }
    }

    @PostMapping("/delete/{id}")
    public TeamEntity deleteTeam(@PathVariable(name = "id", required = true) int id){
        Optional<TeamEntity> teamEntity = repository.findById(id);
        if (teamEntity.isPresent()) {
            repository.delete(teamEntity.get());
            return teamEntity.get();
        }
        else throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Team not found");
    }

}
