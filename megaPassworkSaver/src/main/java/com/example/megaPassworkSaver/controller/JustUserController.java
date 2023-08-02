package com.example.megaPassworkSaver.controller;

import com.example.megaPassworkSaver.data.model.AppUser;
import com.example.megaPassworkSaver.service.JustUserService;
import com.example.megaPassworkSaver.serviceImpl.HttpResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.time.LocalDateTime;
import java.util.Map;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class JustUserController {
    private final JustUserService justUserService;

    @PostMapping("/createJustUser")
    public ResponseEntity<HttpResponse> registerJustUser(@RequestBody AppUser appUser){
       AppUser  appUser1 = justUserService.registerUser(appUser);
       return  ResponseEntity.created(URI.create("")).body(
               HttpResponse.builder()
                       .timeStamp(LocalDateTime.now().toString())
                       .data(Map.of("user", appUser1))
                       .message("app user created successfully")
                       .status(HttpStatus.CREATED)
                       .statusCode(HttpStatus.CREATED.value())
                       .build());
    }
@GetMapping("/validtate")
    public  ResponseEntity<HttpResponse> validateUser(@RequestParam("token")String token){
   Boolean isSuccess = justUserService.verifyToken(token);
    return  ResponseEntity.ok().body(
            HttpResponse.builder()
                    .timeStamp(LocalDateTime.now().toString())
                    .data(Map.of("Validation successfully", isSuccess))
                    .message("account verified successfully")
                    .status(HttpStatus.OK)
                    .statusCode(HttpStatus.OK.value())
                    .build());
}


}
