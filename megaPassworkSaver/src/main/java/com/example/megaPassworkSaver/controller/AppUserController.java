package com.example.megaPassworkSaver.controller;

import com.electronwill.nightconfig.core.conversion.Path;
import com.example.megaPassworkSaver.data.model.AppUser;
import com.example.megaPassworkSaver.data.model.Password;
import com.example.megaPassworkSaver.data.model.Token;
import com.example.megaPassworkSaver.dto.UnlockPassword;
import com.example.megaPassworkSaver.dto.request.AppUserRequest;
import com.example.megaPassworkSaver.dto.request.PageRequestDto;
import com.example.megaPassworkSaver.dto.response.AppUserResponse;
import com.example.megaPassworkSaver.service.AppUserService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequestMapping("/api")
@RequiredArgsConstructor
@RestController
public class AppUserController {
    private final AppUserService appUserService;

@PostMapping("/registerUser")
    public ResponseEntity<AppUserResponse> registerAppUser(@RequestBody AppUserRequest appUserRequest){
        return new ResponseEntity<>(appUserService.registerNewUser(appUserRequest), HttpStatus.CREATED);
    }
    @PostMapping("/createPassword")
    public ResponseEntity<AppUserResponse> createNewPassword(@RequestBody Password password){
        return new ResponseEntity<>(appUserService.userSavePassword(password), HttpStatus.CREATED);
    }
    @GetMapping("/viewNumberOfPassword")
    public ResponseEntity<Long> countNumberOfPassword(){
        return new ResponseEntity<>(appUserService.countUsers(), HttpStatus.OK);
    }
    @GetMapping("/countMyPassword/{userEmail}")
    public ResponseEntity<Long> countMyPassword(@PathVariable String userEmail){
        return new ResponseEntity<>(appUserService.countMyPassword(userEmail), HttpStatus.OK);
    }
@DeleteMapping("/deletePassword/{passwordLabel}")
    public ResponseEntity<AppUserResponse> deleteMyPassword(@PathVariable String passwordLabel){
    return new ResponseEntity<>(appUserService.deletePasswordByLabel(passwordLabel),HttpStatus.ACCEPTED);

}
@GetMapping("/generateToken/{passwordLabel},{appUserEmail}")
    public ResponseEntity<Token> generateToken(@PathVariable String passwordLabel,@PathVariable  String appUserEmail){
return new ResponseEntity<>(appUserService.generateAccessToken(passwordLabel, appUserEmail),HttpStatus.FOUND);
}
@GetMapping("/userPassword/{passwordLabel},{token}")
public ResponseEntity<UnlockPassword> unlockPassword(@PathVariable String passwordLabel, @PathVariable String token){
return new ResponseEntity<>(appUserService.getPasswordByLabel(passwordLabel, token),HttpStatus.FOUND);
}

@GetMapping("/getAllPassword")
    public ResponseEntity<Page<UnlockPassword>> viewAllPassword(@RequestBody PageRequestDto pageRequestDto){
return new ResponseEntity<>(appUserService.getAllPassword(pageRequestDto),HttpStatus.OK);
}
@GetMapping("findByEmail/{email}")
public ResponseEntity<AppUser> findByEmail(@PathVariable String email){
 return new ResponseEntity<>(appUserService.findAppUserByEmail(email),HttpStatus.OK);
}
}
