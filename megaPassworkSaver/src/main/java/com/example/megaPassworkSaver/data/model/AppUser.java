package com.example.megaPassworkSaver.data.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.HashSet;
import java.util.Set;

@Entity
@AllArgsConstructor
@Data
@NoArgsConstructor
@Builder
public class AppUser {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @OneToMany( cascade = CascadeType.ALL, mappedBy = "appUser", orphanRemoval = true)
    private  Set<Password> listOfPasswords = new HashSet<>();
    private String userName;
    private String unlockPassword;
    private String emailAddress;
    private String mainQuestion;
    private String mainAnswer;
private  int numberOfPasswords = listOfPasswords.size();
}
