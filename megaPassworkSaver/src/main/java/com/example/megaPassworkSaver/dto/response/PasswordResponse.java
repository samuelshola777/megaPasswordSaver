package com.example.megaPassworkSaver.dto.response;

import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@Builder
public class PasswordResponse {
    private LocalDateTime createdAt;
    private LocalDateTime LastUpdatedAt;
    private String password;
    private String passwordLabel;
    private String appUserEmail;
    private String token;
}
