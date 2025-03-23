package com.ipi.gestionchampionatapi.entites;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.Email;
import lombok.Getter;
import lombok.Setter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import java.util.Date;

@Getter
@Entity
public class UserEntity {

    @Setter
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Setter
    private String firstName;

    @Setter
    private String lastName;

    @Setter
    @Email
    private String email;

    private String password = "";

    @Setter
    private Date creationDate;

    public UserEntity() {
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder(8);
        this.password = encoder.encode(password);
        this.creationDate = new Date();

    }

    public void setPassword(String password) {
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder(8);
        this.password = encoder.encode(password);
    }
}
