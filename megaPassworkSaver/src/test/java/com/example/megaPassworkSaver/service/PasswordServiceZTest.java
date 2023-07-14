package com.example.megaPassworkSaver.service;

import com.example.megaPassworkSaver.data.model.Password;
import lombok.RequiredArgsConstructor;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
@RequiredArgsConstructor
class PasswordServiceZTest {
    private final PasswordServiceZ passwordService;


private Password password1;
private Password password2;
private Password password3;

    @BeforeEach
    void setUp() {

        password1 = new Password();
        password1.setPassword("SAMUELSHOLA14@GMAIL.COM");
        password1.setPasswordLabel("my data base password");
        password1.setAppUserEmail("marthins4@gmail.com");

        password2 = new Password();
        password2.setPasswordLabel("my facebook password");
        password2.setAppUserEmail("marthins4@gmail.com");
        password2.setPassword("blueboat");

        password3 = new Password();
        password3.setPassword("SAMBONE90933");
        password3.setPasswordLabel("my github password");
        password3.setAppUserEmail("samuelshola14@gmail.com");


    }
    @Test
    void testThatPasswordCanBeCreated(){
        passwordService.createPassword(password1);
        passwordService.createPassword(password2);
        passwordService.createPassword(password3);
    }

}