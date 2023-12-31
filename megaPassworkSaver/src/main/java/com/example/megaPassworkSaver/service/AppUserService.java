package com.example.megaPassworkSaver.service;

import com.example.megaPassworkSaver.data.model.AppUser;
import com.example.megaPassworkSaver.data.model.Password;
import com.example.megaPassworkSaver.data.model.Token;
import com.example.megaPassworkSaver.dto.UnlockPassword;
import com.example.megaPassworkSaver.dto.request.AppUserRequest;
import com.example.megaPassworkSaver.dto.request.PageRequestDto;
import com.example.megaPassworkSaver.dto.response.AppUserResponse;
import com.example.megaPassworkSaver.dto.response.PasswordResponse;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;


public interface AppUserService {


    AppUserResponse registerNewUser(AppUserRequest appUserRequest3);

    long countUsers();

    AppUserResponse userSavePassword(Password password1);

    long countMyPassword(String mail);

    AppUserResponse deletePasswordByLabel(String passwordLabel);
    Token generateAccessToken(String passwordLabel, String emailAddress);
    UnlockPassword getPasswordByLabel(String myDataBasePassword, String token);

    long deleteAllPassword(String mail, String myGithubPassword);
    Page<UnlockPassword> getAllPassword(PageRequestDto pageRequestDto);
    AppUser findAppUserByEmail(String email);

    String deleteAppUserAccountByEmail(String stringEmail);
}
