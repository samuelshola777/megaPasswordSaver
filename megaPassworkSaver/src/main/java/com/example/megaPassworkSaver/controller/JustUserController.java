package com.example.megaPassworkSaver.controller;

import com.example.megaPassworkSaver.data.model.AppUser;
import com.example.megaPassworkSaver.service.JustUserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class JustUserController {
    private final JustUserService justUserService;

    @PostMapping("/createJustUser")
    public ResponseEntity<?> registerJustUser(@RequestBody AppUser appUser){

    }


}
