package com.example.megaPassworkSaver.dto.request;

import com.example.megaPassworkSaver.data.model.Password;
import jakarta.persistence.CascadeType;
import jakarta.persistence.OneToMany;

import java.util.Set;

public class AppUserRequest {

    private Set<Password> listOfPasswords;
    private String userName;
    private String emailAddress;
}
