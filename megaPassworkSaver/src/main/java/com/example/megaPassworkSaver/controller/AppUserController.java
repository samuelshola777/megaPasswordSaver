package com.example.megaPassworkSaver.controller;

import com.example.megaPassworkSaver.data.model.Password;
import com.example.megaPassworkSaver.dto.request.AppUserRequest;
import com.example.megaPassworkSaver.dto.response.AppUserResponse;
import com.example.megaPassworkSaver.service.AppUserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("api/passwordStorage")
@RequiredArgsConstructor
@RestController
public class AppUserController {
    private final AppUserService appUserService;

@RequestMapping("/registerUser")
    public ResponseEntity<AppUserResponse> registerAppUser(@RequestBody AppUserRequest appUserRequest){
        return new ResponseEntity<>(appUserService.registerNewUser(appUserRequest), HttpStatus.CREATED);
    }
    @RequestMapping("/createPassword")
    public ResponseEntity<AppUserResponse> createNewPassword(@RequestBody Password password){
        return new ResponseEntity<>(appUserService.userSavePassword(password), HttpStatus.CREATED);
    }
    @GetMapping("/viewNumberOfPassword")
    public ResponseEntity<Long> countNumberOfPassword(){

    }

}
