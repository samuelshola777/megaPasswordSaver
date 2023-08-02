package com.example.megaPassworkSaver.service;

import com.example.megaPassworkSaver.data.model.AppUser;
import com.example.megaPassworkSaver.dto.request.AppUserRequest;

public interface JustUserService {
    AppUser registerUser(AppUser request);
    Boolean verifyToken(String token);

}
