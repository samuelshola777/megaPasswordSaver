package com.example.megaPassworkSaver.serviceImpl;

import com.example.megaPassworkSaver.data.model.AppUser;
import com.example.megaPassworkSaver.data.repository.AppUserRepository;
import com.example.megaPassworkSaver.dto.request.AppUserRequest;
import com.example.megaPassworkSaver.dto.response.AppUserResponse;
import com.example.megaPassworkSaver.exception.EmailAlreadyExistException;
import com.example.megaPassworkSaver.exception.RegistrationException;
import com.example.megaPassworkSaver.service.AppUserService;
import com.example.megaPassworkSaver.service.PasswordServiceZ;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.nio.charset.StandardCharsets;
import java.util.Base64;

@RequiredArgsConstructor
@Service
public class AppUserServiceImpl implements AppUserService {
    private final AppUserRepository appUserRepository;
//   @Autowired
//    private  AppUserRepository appUserRepository;

    @Override
    public AppUserResponse registerNewUser(AppUserRequest appUserRequest3) {
        ifEmailAlreadyExist(appUserRequest3.getEmailAddress());
        passwordVerifier(appUserRequest3.getUnlockPassword());
        AppUser mappedAppUser = mapRequestToAppUser(appUserRequest3);
        return mapAppUserToResponse(appUserRepository.save(mappedAppUser));
    }
    private void ifEmailAlreadyExist(String emailAddress) {
        AppUser foundAppUser = appUserRepository.findByEmailAddress(emailAddress);
       if (foundAppUser!= null) throw new EmailAlreadyExistException("email already Exist");

    }
        private void passwordVerifier(String password) {
        int digit = 0;
        for (int i = 0; i <password.length() ; i++) {
            if (Character.isDigit(password.charAt(i))) digit ++;
        }
        if (digit < 3) throw new RegistrationException("invalid password At least password most contain 3 digit");
        }
        private AppUser mapRequestToAppUser(AppUserRequest appUserRequest){
        return AppUser.builder()
                .userName(appUserRequest.getUserName())
                .emailAddress(appUserRequest.getEmailAddress())
                .build();
        }
        private AppUserResponse mapAppUserToResponse(AppUser appUser){
        return AppUserResponse.builder()
                .userName(appUser.getUsername())
                .build();
        }

//        private String passwordEncoder(String password){
//
//        }






        }
