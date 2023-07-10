package com.example.megaPassworkSaver.service;

import com.example.megaPassworkSaver.dto.request.AppUserRequest;
import jakarta.annotation.Nonnull;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.junit.jupiter.api.BeforeEach;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
@RequiredArgsConstructor
class AppUserServiceTest {
    @Nonnull
    private final AppUserService appUserService;
    private AppUserRequest appUserRequest1;
    private AppUserRequest appUserRequest2;
    private AppUserRequest appUserRequest3;

    @BeforeEach
    void setUp() {
    appUserRequest1 = new AppUserRequest();

    appUserRequest1.setUserName("boneshaker");
    appUserRequest1.setEmailAddress("boneshaker@gmail.com");
    appUserRequest1.setUnlockPassword("unlock21");
    appUserRequest1.setMainQuestion("2");
    appUserRequest1.setMainAnswer("goat");


    appUserRequest2 = new AppUserRequest();
    appUserRequest2.setEmailAddress("samuelshola14@gmail.com");
    appUserRequest2.setUserName("samuelshola14");


    appUserRequest3 = new AppUserRequest();

    appUserRequest3.setUserName("marthins");
    appUserRequest3.setEmailAddress("marthins4@gmail.com");

    }
}