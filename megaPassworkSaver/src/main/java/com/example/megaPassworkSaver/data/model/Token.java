package com.example.megaPassworkSaver.data.model;

import jakarta.persistence.*;
import lombok.*;
import org.springframework.scheduling.annotation.EnableScheduling;

import java.time.LocalDateTime;
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
public class Token {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @ManyToOne
    private Password password;
    private long id;
    private String token;
    private LocalDateTime generatedAt;
    private LocalDateTime expiredAt;

}
