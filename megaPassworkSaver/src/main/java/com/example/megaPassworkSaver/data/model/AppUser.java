package com.example.megaPassworkSaver.data.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;

import java.util.List;
import java.util.Set;

@Entity
@AllArgsConstructor
public class AppUser {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @OneToMany()
    private final Set<Password> listOfPasswords;
    private String userName;
    private String unlockPassword;
}
