package com.example.megaPassworkSaver.controller;

import com.example.megaPassworkSaver.dto.request.AppUserRequest;
import com.example.megaPassworkSaver.dto.response.AppUserResponse;
import com.example.megaPassworkSaver.service.AppUserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("api/passwordStorage")
@RequiredArgsConstructor
@RestController
public class AppUserController {
    private final AppUserService appUserService;



    public ResponseEntity<AppUserResponse> registerAppUser(@RequestBody AppUserRequest appUserRequest){

    }

}
