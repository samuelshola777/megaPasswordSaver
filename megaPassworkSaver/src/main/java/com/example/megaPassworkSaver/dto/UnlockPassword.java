package com.example.megaPassworkSaver.dto;

import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;
@Builder
@Data
public class UnlockPassword {
    private String appUserEmail;
    private String token;
    private String password;
    private String passwordLabel;
    private LocalDateTime createdAt;
    private  long numberOfPasswords ;
    private LocalDateTime LastUpdatedAt;
}
