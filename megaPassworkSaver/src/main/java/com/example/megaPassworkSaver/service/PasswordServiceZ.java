package com.example.megaPassworkSaver.service;

import com.example.megaPassworkSaver.data.model.Password;

public interface PasswordServiceZ {
    Password createPassword(Password password2);
    long countAllPassword();

    void deleteAllPassword();
}
