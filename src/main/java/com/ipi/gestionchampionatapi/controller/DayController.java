package com.ipi.gestionchampionatapi.controller;

import com.ipi.gestionchampionatapi.entites.DayEntity;
import com.ipi.gestionchampionatapi.repository.DayRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/day")
public class DayController {

    @Autowired
    private DayRepository dayRepo;

    @GetMapping("/getall")
    public List<DayEntity> getAllDays() {return dayRepo.findAll();}

    @GetMapping("/getbyid/{id}")
    public DayEntity getDayById(@PathVariable(name = "id", required = true) int id) {
        Optional<DayEntity> day = dayRepo.findById(id);
        if (day.isPresent()) {
            return day.get();
        }
        else throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Id de jour invalide");
    }

    @PostMapping("/create")
    public DayEntity createDay(@RequestBody DayEntity day) {
        return dayRepo.save(day);
    }

    @GetMapping("/getbychampionship/{id}")
    public List<DayEntity> getDaysByChampionship(@PathVariable(name = "id", required = true) int id) {
        return dayRepo.findByChampionshipId(id);
    }

    @PostMapping("/update/{id}")
    public DayEntity updateDay(@PathVariable(name = "id", required = true) int id, @RequestBody DayEntity day) {
        if (day == null) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Id de jour invalide");
        }
        Optional<DayEntity> dayEntity = dayRepo.findById(id);
        if (dayEntity.isEmpty()) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Id de jour invalide");
        }
        else {
            day.setId(id);
            return dayRepo.save(day);
        }
    }

    @PostMapping("/delete/{id}")
    public DayEntity deleteDay(@PathVariable(name = "id", required = true) int id) {
        Optional<DayEntity> day = dayRepo.findById(id);
        if (day.isPresent()) {
            dayRepo.delete(day.get());
            return day.get();
        }
        else throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Id de jour invalide");
    }

}
