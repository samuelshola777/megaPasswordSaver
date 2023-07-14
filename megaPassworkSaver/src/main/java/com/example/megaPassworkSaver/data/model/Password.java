package com.example.megaPassworkSaver.data.model;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Entity
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Password {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @ManyToOne(fetch = FetchType.LAZY)
    private AppUser appUser;
    private LocalDateTime createdAt;
    private LocalDateTime LastUpdatedAt;
    private String password;
    private String passwordLabel;

}
