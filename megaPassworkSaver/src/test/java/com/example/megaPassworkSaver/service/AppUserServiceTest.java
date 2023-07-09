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


    }
}