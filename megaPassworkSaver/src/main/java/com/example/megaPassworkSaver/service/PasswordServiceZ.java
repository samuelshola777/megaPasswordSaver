package com.example.megaPassworkSaver.service;

import com.example.megaPassworkSaver.data.model.Password;
import com.example.megaPassworkSaver.data.model.Token;
import com.example.megaPassworkSaver.dto.UnlockPassword;
import com.example.megaPassworkSaver.dto.request.PageRequestDto;
import com.example.megaPassworkSaver.dto.response.PasswordResponse;
import org.springframework.data.domain.Page;

public interface PasswordServiceZ {
    Password createPassword(Password password2);
    long countAllPassword();

    void deleteAllPassword();

    void deletePasswordByLabel(String passwordLabel);
    Token tokenGenerator(String passwordLabel);
   UnlockPassword mapToUnlockPassword(Password foundPassword);
   UnlockPassword mapToUnlockPasswordWithWrongToken(Password foundPassword );
     Page<PasswordResponse> viewAllPasswordWithWrongToken(PageRequestDto pageRequestDto);
    Page<PasswordResponse> viewAllPassword(PageRequestDto pageRequestDto);
     String decryptPassword(String encodedPassword);
    Password findPassword(String passwordLabel);

    void deleteAllToken();
}
