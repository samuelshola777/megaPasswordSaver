package com.example.megaPassworkSaver.data.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.CreatedDate;

import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Data
@NoArgsConstructor
public class Confirmation {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String tokenC;
    @Temporal(TemporalType.TIMESTAMP)
    @CreatedDate
    private LocalDateTime createdAt;
    @OneToOne(targetEntity = AppUser.class, fetch = FetchType.LAZY)
@JoinColumn(nullable = false, name = "app_user_id")
    private AppUser appUser;
public Confirmation(AppUser appUser){
    this.appUser = appUser;
    this.createdAt = LocalDateTime.now();
    this.tokenC = UUID.randomUUID().toString();

}
}
