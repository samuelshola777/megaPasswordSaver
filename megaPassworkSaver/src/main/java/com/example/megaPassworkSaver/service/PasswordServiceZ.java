package com.example.megaPassworkSaver.service;

import com.example.megaPassworkSaver.data.model.Password;
import com.example.megaPassworkSaver.data.model.Token;
import com.example.megaPassworkSaver.dto.UnlockPassword;

public interface PasswordServiceZ {
    Password createPassword(Password password2);
    long countAllPassword();

    void deleteAllPassword();

    void deletePasswordByLabel(String passwordLabel);
    Token tokenGenerator(String passwordLabel);
   UnlockPassword mapToUnlockPassword(Password foundPassword);
   UnlockPassword mapToUnlockPasswordWithWrongToken(Password foundPassword );
     String decryptPassword(String encodedPassword);
    Password findPassword(String passwordLabel);

    void deleteAllToken();
}
