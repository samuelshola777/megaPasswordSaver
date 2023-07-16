package com.example.megaPassworkSaver.data.model;


import jakarta.persistence.*;
import lombok.*;


import java.time.LocalDateTime;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
@Entity
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
