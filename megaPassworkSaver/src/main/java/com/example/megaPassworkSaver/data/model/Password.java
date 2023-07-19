package com.example.megaPassworkSaver.data.model;


import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Password {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @ManyToOne
    private AppUser appUser;
    @Column(unique = true)
    private String appUserEmail;
    private String token;
    @OneToMany( cascade = CascadeType.ALL, mappedBy = "password", orphanRemoval = true)
    private List<Token> listOfTokens = new ArrayList<>();
    private LocalDateTime createdAt;
    private LocalDateTime LastUpdatedAt;
    private String password;
    private String passwordLabel;

}
