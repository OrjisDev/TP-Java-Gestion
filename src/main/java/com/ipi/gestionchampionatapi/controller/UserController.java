package com.ipi.gestionchampionatapi.controller;

import com.ipi.gestionchampionatapi.entites.UserEntity;
import com.ipi.gestionchampionatapi.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserRepository userRepository;

    @GetMapping("/getall")
    public List<UserEntity> getAllUsers() {
        return userRepository.findAll();
    }

    @GetMapping("/get/{id}")
    public UserEntity getUserById(@PathVariable(name = "id", required = true) int id) {
        Optional<UserEntity> userEntity = userRepository.findById(id);
        if (userEntity.isPresent()) {
            return userEntity.get();
        }
        else throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Id d'utilisateur n'existe pas");
    }

    @GetMapping("/get/{email}")
    public UserEntity getUserByEmail(@PathVariable(name = "email", required = true) String email) {
        Optional<UserEntity> userEntity = userRepository.findByEmail(email);
        if (userEntity.isPresent()) {
            return userEntity.get();
        }
        else throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Email d'utilisateur n'existe pas");
    }

    @PostMapping("/create")
    public UserEntity createUser(@RequestBody UserEntity user) {
        if (user == null) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Utilisateur vide");
        }
        else{
            BCryptPasswordEncoder encoder = new BCryptPasswordEncoder(16);
            user.setPassword(encoder.encode(user.getPassword()));
            return userRepository.save(user);
        }
    }


}
