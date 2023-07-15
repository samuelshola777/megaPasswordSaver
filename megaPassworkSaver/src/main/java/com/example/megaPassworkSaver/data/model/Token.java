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
    private Long id;

    @ManyToOne
    private Password password;

    private String token;
    private LocalDateTime generatedAt;
    private LocalDateTime expiredAt;

}
