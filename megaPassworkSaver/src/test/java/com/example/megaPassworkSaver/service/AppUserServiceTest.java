package com.example.megaPassworkSaver.service;

import com.example.megaPassworkSaver.data.model.Password;
import com.example.megaPassworkSaver.dto.request.AppUserRequest;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest

class AppUserServiceTest {
@Autowired
private  AppUserService appUserService;

    private Password password1;
    private Password password2;
    private Password password3;
    private AppUserRequest appUserRequest1;
    private AppUserRequest appUserRequest2;
    private AppUserRequest appUserRequest3;

    @BeforeEach
    void setUp() {
    appUserRequest1 = new AppUserRequest();

    appUserRequest1.setUserName("boneshaker");
    appUserRequest1.setEmailAddress("boneshaker@gmail.com");
        appUserRequest1.setPassword("itwontwork443s");



    appUserRequest2 = new AppUserRequest();
    appUserRequest2.setEmailAddress("samuelshola14@gmail.com");
    appUserRequest2.setUserName("samuelshola14");
        appUserRequest2.setPassword("noWeapon321");



    appUserRequest3 = new AppUserRequest();

    appUserRequest3.setUserName("marthins");
    appUserRequest3.setEmailAddress("marthins4@gmail.com");
    appUserRequest3.setPassword("goatAndPasswords879");

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
        password3.setPasswordLabel("my github passwordZ");
        password3.setAppUserEmail("samuelshola14@gmail.com");
    }


    @Test
    void testThatApUserCanRegister(){

        assertNotNull(appUserService.registerNewUser(appUserRequest1));
        assertNotNull(appUserService.registerNewUser(appUserRequest2));
        assertNotNull(appUserService.registerNewUser(appUserRequest3));

      //  assertEquals(3,appUserService.countUsers());



    }
    @Test
    void testThatAppUserCanSavePassword(){

  assertNotNull(appUserService.userSavePassword(password1));
  assertNotNull(appUserService.userSavePassword(password2));
  assertNotNull(appUserService.userSavePassword(password3));
    }
    @Test
    void  testThatAppUserCanDeletePasswordByLabel(){
        appUserService.deletePasswordByLabel("my data base password");
    }
    @Test
    void testThatAppUserCanViewPassword(){
        assertEquals("SAMBONE90933",
        appUserService.getPasswordByLabel("my github password",
    appUserService.generateAccessToken("my github password","samuelshola14@gmail.com")
    .getToken()).getPassword());
    }
    @Test 
    void tesThatAppUserCanDeleteAllPassword(){

      assertEquals(0,  appUserService.deleteAllPassword("marthins4@gmail.com",
          appUserService.generateAccessToken("my data base password"
                  ,"marthins4@gmail.com").getToken()));
    }
    @Test
    void testThatAppUserCanBeDeletedByEmail(){
        appUserService.deleteAppUserAccountByEmail("samuelshola14@gmail.com");
    }

}