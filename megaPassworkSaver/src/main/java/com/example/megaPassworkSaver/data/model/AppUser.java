package com.example.megaPassworkSaver.data.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import java.util.List;
@Entity
public class AppUser {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private final List<Password> listOfPasswords;
    private String userName;
    private String unlockPassword;
}
