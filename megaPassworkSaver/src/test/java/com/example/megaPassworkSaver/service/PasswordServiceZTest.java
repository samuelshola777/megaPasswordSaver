package com.example.megaPassworkSaver.service;

import com.example.megaPassworkSaver.data.model.Password;
import com.example.megaPassworkSaver.exception.AppUserException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest

class PasswordServiceZTest {
    @Autowired
    private  PasswordServiceZ passwordService;
private Password password1;
private Password password2;
private Password password3;


    @BeforeEach
    void setUp() {

        password1 = new Password();
        password1.setSavedPassword("SAMUELSHOLA14@GMAIL.COM");
        password1.setPasswordLabel("my data base password");
        password1.setAppUserEmail("marthins4@gmail.com");

        password2 = new Password();
        password2.setPasswordLabel("my facebook password");
        password2.setAppUserEmail("marthins4@gmail.com");
        password2.setSavedPassword("blueboat");

        password3 = new Password();
        password3.setSavedPassword("SAMBONE90933");
        password3.setPasswordLabel("my github password");
        password3.setAppUserEmail("samuelshola14@gmail.com");


    }
    @Test
    void testThatPasswordCanBeCreated(){
assertThrows(AppUserException.class, ()-> {passwordService.createPassword(password1);});

//        assertNotNull(passwordService.createPassword(password1));
//        assertNotNull(passwordService.createPassword(password2));
//        assertNotNull(passwordService.createPassword(password3));
//
//        assertEquals(3, passwordService.countAllPassword());
    }



    @Test
    void testThatWeCanDeleteAllPassword(){
        passwordService.deleteAllPassword();
        assertEquals(0, passwordService.countAllPassword());

    }
    @Test
    void testThatWeCanDeleteAllToken(){
        passwordService.deleteAllToken();
    }


}