package com.example.megaPassworkSaver.controller;

import com.example.megaPassworkSaver.data.model.Password;
import com.example.megaPassworkSaver.data.model.Token;
import com.example.megaPassworkSaver.dto.UnlockPassword;
import com.example.megaPassworkSaver.dto.request.AppUserRequest;
import com.example.megaPassworkSaver.dto.response.AppUserResponse;
import com.example.megaPassworkSaver.service.AppUserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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
        return new ResponseEntity<>(appUserService.countUsers(), HttpStatus.OK);
    }
    @GetMapping("/countMyPassword")
    public ResponseEntity<Long> countMyPassword(String userEmail){
        return new ResponseEntity<>(appUserService.countMyPassword(userEmail), HttpStatus.OK);
    }
@DeleteMapping("/deletePassword")
    public ResponseEntity<AppUserResponse> deleteMyPassword(String passwordLabel){
    return new ResponseEntity<>(appUserService.deletePasswordByLabel(passwordLabel),HttpStatus.ACCEPTED);

}
@GetMapping("/generateToken")
    public ResponseEntity<Token> generateToken(String passwordLabel, String appUserEmail){
return new ResponseEntity<>(appUserService.generateAccessToken(passwordLabel, appUserEmail),HttpStatus.FOUND);
}
@GetMapping("/userPassword")
public ResponseEntity<UnlockPassword> unlockPassword(@RequestParam String passwordLabel, @RequestParam String token){
return new ResponseEntity<>(appUserService.getPasswordByLabel(passwordLabel, token),HttpStatus.FOUND);
}


}
