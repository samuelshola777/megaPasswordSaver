package com.example.megaPassworkSaver.service;

import com.example.megaPassworkSaver.dto.request.AppUserRequest;
import jakarta.annotation.Nonnull;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest

class AppUserServiceTest {
@Autowired
    private  AppUserService appUserService;
    private AppUserRequest appUserRequest1;
    private AppUserRequest appUserRequest2;
    private AppUserRequest appUserRequest3;

    @BeforeEach
    void setUp() {
    appUserRequest1 = new AppUserRequest();

    appUserRequest1.setUserName("boneshaker");
    appUserRequest1.setEmailAddress("boneshaker@gmail.com");
        appUserRequest1.setPassword("it wont work443s");



    appUserRequest2 = new AppUserRequest();
    appUserRequest2.setEmailAddress("samuelshola14@gmail.com");
    appUserRequest2.setUserName("samuelshola14");
        appUserRequest2.setPassword("noWeapon321");



    appUserRequest3 = new AppUserRequest();

    appUserRequest3.setUserName("marthins");
    appUserRequest3.setEmailAddress("marthins4@gmail.com");
    appUserRequest3.setPassword("goatAndPasswords879");
    }


    @Test
    void testThatApUserCanRegister(){

        assertNotNull(appUserService.registerNewUser(appUserRequest1));
        assertNotNull(appUserService.registerNewUser(appUserRequest2));
        assertNotNull(appUserService.registerNewUser(appUserRequest3));



    }

}