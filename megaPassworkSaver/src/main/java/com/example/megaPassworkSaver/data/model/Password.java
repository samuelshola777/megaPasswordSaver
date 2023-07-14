package com.example.megaPassworkSaver.data.model;


import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import lombok.*;

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
    @NotEmpty
    @NotBlank
    @ManyToOne(fetch = FetchType.LAZY)
    private AppUser appUser;
    private String appUserEmail;
    private LocalDateTime createdAt;
    private LocalDateTime LastUpdatedAt;
    private String password;
    private String passwordLabel;

}
