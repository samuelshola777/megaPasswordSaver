package com.example.megaPassworkSaver.service;

import com.example.megaPassworkSaver.dto.request.AppUserRequest;
import com.example.megaPassworkSaver.dto.response.AppUserResponse;
import org.springframework.stereotype.Service;


public interface AppUserService {


    AppUserResponse registerNewUser(AppUserRequest appUserRequest3);

    long countUsers();
}
