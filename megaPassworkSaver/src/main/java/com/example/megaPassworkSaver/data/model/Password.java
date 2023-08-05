package com.example.megaPassworkSaver.data.model;


import com.fasterxml.jackson.annotation.JsonIgnore;
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
    @JsonIgnore
    @ManyToOne(fetch = FetchType.LAZY)
//    @JoinColumn(name = "app_user")
    private AppUser appUser;
    private String appUserEmail;
    private String token;
    @JsonIgnore
    @OneToMany( cascade = CascadeType.ALL, mappedBy = "password", orphanRemoval = true)
    private List<Token> listOfTokens = new ArrayList<>();
    private LocalDateTime createdAt;
    private LocalDateTime LastUpdatedAt;
    private String savedPassword;
    private String passwordLabel;

}
