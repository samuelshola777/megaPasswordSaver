package com.example.megaPassworkSaver.dto.response;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class AppUserResponse {
    private String userName;
    private int numberOfPasswords ;
}
